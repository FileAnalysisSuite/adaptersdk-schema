/**
 * Copyright 2022-2025 Open Text.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
using System;
using System.CodeDom;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Reflection;
using System.Text;
using System.Text.Json.Nodes;
using Microsoft.CSharp;

namespace MicroFocus.FAS.AdapterSdkSchema
{
    public class SchemaSourceCreator
    {
        private readonly List<PropertyNameHelper> propertyNames;
        private readonly Dictionary<string, CodeConstructor> propertyConstructors;
        private JsonNode typesNode;

        private SchemaSourceCreator()
        {
            propertyNames = new List<PropertyNameHelper>();
            propertyConstructors = new Dictionary<string, CodeConstructor>();
        }

        public static string Create()
        {
            JsonNode schemaJson = SchemaGeneratorHelper.ParseSchemaDefinition();

            var schemaSource = new SchemaSourceCreator().CreateSchemaSource(schemaJson);
            Debug.WriteLine("Schema source : " + schemaSource);
            return schemaSource;
        }

        private string CreateSchemaSource(JsonNode schemaJson)
        {
            typesNode = schemaJson["types"].AsObject();
            JsonNode fields = schemaJson["fields"].AsObject();

            CodeCompileUnit schemaCompileUnit = new();

            // Create namespace
            CodeNamespace schemaNamespace = new(SchemaGeneratorHelper.NAMESPACE_NAME);
            schemaCompileUnit.Namespaces.Add(schemaNamespace);
            schemaNamespace.Comments.Add(
                new CodeCommentStatement("This file is auto-generated by SchemaGenerator"));

            // Define the class and add it to namespace
            CodeTypeDeclaration schemaClassBuilder = new(SchemaGeneratorHelper.CLASS_NAME)
            {
                TypeAttributes = TypeAttributes.Public | TypeAttributes.Class
            };
            schemaNamespace.Types.Add(schemaClassBuilder);

            // Add properties
            AddPropertyFields(schemaClassBuilder, fields, new string[0], "", true);

            // Add property accessors
            AddPropertyAccessors(schemaClassBuilder);

            using StringWriter writer = new();
            CSharpCodeProvider provider = new();
            provider.GenerateCodeFromCompileUnit(schemaCompileUnit, writer, new CodeGeneratorOptions());

            return writer.ToString().Replace(
                "public class " + SchemaGeneratorHelper.CLASS_NAME,
                "public static class " + SchemaGeneratorHelper.CLASS_NAME);
        }

        private void AddPropertyFields(CodeTypeDeclaration classBuilder,
            JsonNode entityDef, string[] path, string parentFieldName, bool initialize)
        {
            IEnumerator<KeyValuePair<string, JsonNode>> propertyIterator = entityDef.AsObject().GetEnumerator();

            bool isSubfield = path.Length > 0;
            string fieldImplClass = isSubfield ? "SubfieldImpl" : "FieldImpl";
            MemberAttributes fieldOrTypeModifiers = isSubfield
                ? MemberAttributes.Public
                : MemberAttributes.Public | MemberAttributes.Static;

            while (propertyIterator.MoveNext())
            {
                KeyValuePair<string, JsonNode> property = propertyIterator.Current;
                JsonNode fieldAttributes = property.Value;
                string propertyName = property.Key;
                string ucPropertyName = propertyName.ToUpperInvariant();
                string sanitizedPropertyName = ucPropertyName.Replace('-', '_');

                if (!isSubfield)
                {
                    propertyNames.Add(new PropertyNameHelper(
                        propertyName, ucPropertyName, sanitizedPropertyName));
                }
                else
                {
                    string subFieldPropertyName = parentFieldName + "." + propertyName;
                    string subFieldUcPropertyName = subFieldPropertyName.ToUpperInvariant();
                    string subFieldSanitizedPropertyName = subFieldUcPropertyName.Replace('-', '_');

                    propertyNames.Add(new PropertyNameHelper(
                        subFieldPropertyName, subFieldUcPropertyName, subFieldSanitizedPropertyName));
                }

                string fieldType = fieldAttributes["type"].GetValue<string>();

                int endOfArrayDimension = fieldType.LastIndexOf('[');
                string fieldTypeValue = endOfArrayDimension > 0
                    ? fieldType.Substring(0, endOfArrayDimension)
                    : fieldType;

                string fldEncoding = fieldAttributes["objectEncoding"] != null
                    ? fieldAttributes["objectEncoding"].GetValue<string>()
                    : "json";
                bool fldIsMultiValued = fieldType.EndsWith("[]");
                bool fldIsMandatory = fieldAttributes["mandatory"] != null
                    && Boolean.Parse(fieldAttributes["mandatory"].GetValue<string>());
                bool fldIsCaseInsensitive = fieldAttributes["ignoreCase"] != null
                    && Boolean.Parse(fieldAttributes["ignoreCase"].GetValue<string>());
                bool fldIsTokenizedPath = fieldAttributes["tokenizedPath"] != null
                    && Boolean.Parse(fieldAttributes["tokenizedPath"].GetValue<string>());

                if (!SchemaGeneratorHelper.PROPERTY_TYPES.Contains(fieldType))
                {
                    string fieldName = SchemaGeneratorHelper.ToProperCase(propertyName) + "Field";
                    string[] newPath = SchemaGeneratorHelper.AddExtraElement(path, fieldName);
                    string fullName = isSubfield ? parentFieldName + "." + propertyName : propertyName;

                    string fieldClassName = String.Join(".", newPath);

                    CodeMemberField field = new()
                    {
                        Name = sanitizedPropertyName,
                        Attributes = fieldOrTypeModifiers,
                        Type = new CodeTypeReference("readonly " + fieldClassName),
                        InitExpression = new CodeObjectCreateExpression(new CodeTypeReference(fieldClassName))
                    };

                    int endOfTypeName = fieldType.IndexOf('[');
                    string refTypeName = endOfTypeName > 0
                        ? fieldType.Substring(0, endOfTypeName)
                        : fieldType;
                    JsonNode subentityDef = typesNode[refTypeName];

                    CodeTypeDeclaration fieldClassBuilder = new(fieldName)
                    {
                        IsClass = true,
                        TypeAttributes = TypeAttributes.Public
                    };

                    fieldClassBuilder.BaseTypes.Add(isSubfield
                        ? new CodeTypeReference("IStructuredSubfield")
                        : new CodeTypeReference("IStructuredField"));

                    CodeMemberField pvtIField = new()
                    {
                        Name = "field",
                        Attributes = MemberAttributes.Private,
                        Type = new CodeTypeReference("readonly IField")
                    };
                    fieldClassBuilder.Members.Add(pvtIField);
                    if (!propertyConstructors.TryGetValue(fullName, out CodeConstructor defaultConstructor))
                    {
                        defaultConstructor = new()
                        {
                            Attributes = MemberAttributes.Assembly
                        };
                        propertyConstructors.Add(fullName, defaultConstructor);
                    }

                    string pvtIFieldInitialization = "new FieldImpl("
                                + "\"" + propertyName + "\", "
                                + "\"" + fieldTypeValue + "\", "
                                + (fldEncoding.Equals("json")
                                    ? "MicroFocus.FAS.AdapterSdkSchema.ObjectEncoding.Json"
                                    : "MicroFocus.FAS.AdapterSdkSchema.ObjectEncoding.Flattened")
                                + ", "
                                + fldIsMultiValued.ToString().ToLower() + ", "
                                + fldIsMandatory.ToString().ToLower() + ", "
                                + fldIsCaseInsensitive.ToString().ToLower() + ", "
                                + fldIsTokenizedPath.ToString().ToLower()
                                + ")";

                    CodeAssignStatement ctorBodyFieldInit = new()
                    {
                        Left = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), "field"),
                        Right = new CodeSnippetExpression(pvtIFieldInitialization)
                    };
                    defaultConstructor.Statements.Add(ctorBodyFieldInit);

                    // Add uninitialized property fields
                    AddPropertyFields(fieldClassBuilder, subentityDef, newPath, fullName, false);

                    fieldClassBuilder.Members.Add(defaultConstructor);

                    // Implement IField interface
                    fieldClassBuilder.Members.AddRange(new[] {
                        new CodeSnippetTypeMember("public string FieldName => field.FieldName;"),
                        new CodeSnippetTypeMember("public string FieldType => field.FieldType;"),
                        new CodeSnippetTypeMember("public ObjectEncoding? ObjectEncoding => field.ObjectEncoding;"),
                        new CodeSnippetTypeMember("public IField ParentField => field.ParentField;"),
                        new CodeSnippetTypeMember("public bool IsMultivalue => field.IsMultivalue;"),
                        new CodeSnippetTypeMember("public bool IsMandatory => field.IsMandatory;"),
                        new CodeSnippetTypeMember("public bool IsCaseInsensitive => field.IsCaseInsensitive;"),
                        new CodeSnippetTypeMember("public bool IsTokenizedPath => field.IsTokenizedPath;")
                    });

                    classBuilder.Members.Add(field);
                    classBuilder.Members.Add(fieldClassBuilder);
                }
                else
                {
                    CodeMemberField field = new()
                    {
                        Name = sanitizedPropertyName,
                        Attributes = fieldOrTypeModifiers,
                        Type = isSubfield
                            ? new CodeTypeReference("readonly ISubfield")
                            : new CodeTypeReference("readonly IField")
                    };

                    string propertyInitialization = "new " + fieldImplClass + "("
                        + "\"" + propertyName + "\", "
                        + "\"" + fieldTypeValue + "\", "
                        + "null, "
                        + fldIsMultiValued.ToString().ToLower() + ", "
                        + fldIsMandatory.ToString().ToLower() + ", "
                        + fldIsCaseInsensitive.ToString().ToLower() + ", "
                        + fldIsTokenizedPath.ToString().ToLower()
                        + (isSubfield ? ", this)" : ")");

                    if (initialize)
                    {
                        // Initialize field value during decleration
                        field.InitExpression = new CodeSnippetExpression(propertyInitialization);
                    }
                    else
                    {
                        // Initialize field value in constructor
                        CodeAssignStatement ctorBodyPropInit = new()
                        {
                            Left = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), propertyName),
                            Right = new CodeSnippetExpression(propertyInitialization)
                        };
                        propertyConstructors[parentFieldName].Statements.Add(ctorBodyPropInit);
                    }
                    classBuilder.Members.Add(field);
                }
            }
        }

        private void AddPropertyAccessors(CodeTypeDeclaration classBuilder)
        {
            CodeParameterDeclarationExpression paramName = new(new CodeTypeReference(typeof(string)), "fieldName");

            CodeParameterDeclarationExpression paramIgnoreCase = new(new CodeTypeReference(typeof(bool)), "ignoreCase");

            CodeMemberMethod getFieldBuilder = new()
            {
                Name = "GetField",
                ReturnType = new CodeTypeReference("IField"),
                Attributes = MemberAttributes.Public | MemberAttributes.Static
            };
            getFieldBuilder.Parameters.Add(paramName);

            CodeMemberMethod getFieldOverloadBuilder = new()
            {
                Name = "GetField",
                ReturnType = new CodeTypeReference("IField"),
                Attributes = MemberAttributes.Public | MemberAttributes.Static
            };
            getFieldOverloadBuilder.Parameters.Add(paramName);
            getFieldOverloadBuilder.Parameters.Add(paramIgnoreCase);

            CodeConditionStatement ifStatement = new()
            {
                Condition = new CodeSnippetExpression("!ignoreCase")
            };
            ifStatement.TrueStatements.Add(new CodeSnippetExpression("return GetField(fieldName)"));

            getFieldOverloadBuilder.Statements.Add(ifStatement);

            // Start Switch block.
            getFieldBuilder.Statements.Add(new CodeSnippetStatement("switch (fieldName){"));
            getFieldOverloadBuilder.Statements.Add(new CodeSnippetStatement("switch (fieldName.ToUpperInvariant()){"));

            foreach (PropertyNameHelper helper in propertyNames)
            {
                AddSwitchCase(getFieldBuilder, helper.propertyName, helper.sanitizedPropertyName);
                AddSwitchCase(getFieldOverloadBuilder, helper.ucPropertyName, helper.sanitizedPropertyName);
            }

            AddSwitchDefault(getFieldBuilder);
            AddSwitchDefault(getFieldOverloadBuilder);

            // End switch block.
            getFieldBuilder.Statements.Add(new CodeSnippetStatement("}"));
            getFieldOverloadBuilder.Statements.Add(new CodeSnippetStatement("}"));

            classBuilder.Members.Add(getFieldBuilder);
            classBuilder.Members.Add(getFieldOverloadBuilder);
        }

        private static void AddSwitchCase(CodeMemberMethod builder, string caseValue, string returnValue)
        {
            CodeSnippetStatement defaultCase = new()
            {
                Value = new StringBuilder("case \"").Append(caseValue).Append("\": ")
                    .Append("return ").Append(returnValue).Append(";")
                    .ToString()
            };
            builder.Statements.Add(defaultCase);
        }

        private static void AddSwitchDefault(CodeMemberMethod builder)
        {
            CodeSnippetStatement defaultCase = new()
            {
                Value = "default:throw new FieldNotFoundException(fieldName);"
            };
            builder.Statements.Add(defaultCase);
        }
    }
}
