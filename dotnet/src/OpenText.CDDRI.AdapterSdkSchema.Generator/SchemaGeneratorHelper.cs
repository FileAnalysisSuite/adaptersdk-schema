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
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text.Json.Nodes;
using YamlDotNet.Serialization;

namespace OpenText.CDDRI.AdapterSdkSchema
{
    internal static class SchemaGeneratorHelper
    {
        internal static readonly string NAMESPACE_NAME = "OpenText.CDDRI.AdapterSdkSchema";
        internal static readonly string CLASS_NAME = "AdapterSdkSchema";
        internal static readonly HashSet<string> PROPERTY_TYPES = new() {
            "STRING", "FULLTEXT", "LONG", "DOUBLE", "INTEGER", "BOOLEAN", "DATETIME",
            "STRING[]", "FULLTEXT[]", "LONG[]", "DOUBLE[]", "INTEGER[]", "BOOLEAN[]", "DATETIME[]"};
        internal static readonly string[] PRIMITIVE_NULLABLE_TYPES = new[] { "LONG","DOUBLE","INTEGER","BOOLEAN"};

        internal static JsonNode ParseSchemaDefinition()
        {
            return ParseSchema("schemaDefinition.json.yaml");
        }

        internal static JsonNode ParseSchema(string schemaPath)
        {
            var assembly = Assembly.GetExecutingAssembly();
            string schemaResourceName = assembly.GetManifestResourceNames().Single(str => str.EndsWith(schemaPath));

            using Stream schemaDefinitionStream = assembly.GetManifestResourceStream(schemaResourceName);
            using StreamReader schemaReader = new(schemaDefinitionStream);

            var schemaDeserializer = new Deserializer();
            var yamlSchema = schemaDeserializer.Deserialize(schemaReader);

            var serializer = new SerializerBuilder().JsonCompatible().Build();
            var json = serializer.Serialize(yamlSchema);

            return JsonNode.Parse(json);
        }

        internal static string ToProperCase(string str)
        {
            TextInfo textInfo = new CultureInfo("en-US", false).TextInfo;
            return textInfo
                .ToTitleCase(str.Replace('_', ' ').Replace('-', ' ').ToLower())
                .Replace(" ", "");
        }

        internal static string ToFieldNameCase(string str)
        {
            string properCase = ToProperCase(str);
            return properCase.Length > 1
                ? char.ToLowerInvariant(properCase[0]) + properCase.Substring(1)
                : char.ToLowerInvariant(properCase[0]).ToString();
        }

        internal static string[] AddExtraElement(string[] element, string extraElement)
        {
            string[] newPath = new string[element.Length + 1];
            element.CopyTo(newPath, 0);
            newPath[element.Length] = extraElement;
            return newPath;
        }

        internal static string ToValidatorFieldName(string propertyName)
        {
            return "_is" + SchemaGeneratorHelper.ToProperCase(propertyName) + "Set";
        }

        internal static bool IsPrimitiveNullableType(string fieldTypeValue)
        {
            return PRIMITIVE_NULLABLE_TYPES.Contains(fieldTypeValue);
        }
    }
}
