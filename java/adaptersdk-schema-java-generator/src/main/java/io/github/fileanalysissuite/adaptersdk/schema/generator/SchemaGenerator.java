/*
 * Copyright 2022 Micro Focus or one of its affiliates.
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
package io.github.fileanalysissuite.adaptersdk.schema.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import io.github.fileanalysissuite.adaptersdk.schema.model.StructuredField;
import io.github.fileanalysissuite.adaptersdk.schema.model.StructuredSubfield;
import io.github.fileanalysissuite.adaptersdk.schema.model.Subfield;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.StringUtils;

@AutoService(Processor.class)
public final class SchemaGenerator extends AbstractProcessor
{
    private static final String PACKAGE_NAME = "io.github.fileanalysissuite.adaptersdk.schema";
    private static final String CLASS_NAME = "AdapterSdkSchema";
    private static final Set<String> PROPERTY_TYPES
        = new HashSet<>(Arrays.asList(
            "STRING", "FULLTEXT", "LONG", "DOUBLE", "INTEGER", "BOOLEAN", "DATETIME",
            "STRING[]", "FULLTEXT[]", "LONG[]", "DOUBLE[]", "INTEGER[]", "BOOLEAN[]", "DATETIME[]"));

    private final List<PropertyNameHelper> propertyNames;
    private JsonNode typesNode;

    private Messager messager;

    public SchemaGenerator()
    {
        propertyNames = new ArrayList<>();
    }

    @Override
    public synchronized void init(final ProcessingEnvironment processingEnv)
    {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes()
    {
        final Set<String> annotataions = new LinkedHashSet<>();
        annotataions.add(AdapterSdkModel.class.getCanonicalName());
        return annotataions;
    }

    @Override
    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv)
    {
        for (final Element annotatedElement : roundEnv.getElementsAnnotatedWith(AdapterSdkModel.class)) {

            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error(annotatedElement, "Only classes can be annotated with @%s",
                      AdapterSdkModel.class.getSimpleName());
                return true;
            }

            final JsonNode schemaNode;
            try {
                schemaNode = parseSchema("schemaDefinition.json.yaml");
            } catch (final IOException e) {
                throw new RuntimeException("Unable to parse schema", e);
            }

            typesNode = schemaNode.get("types");

            final TypeSpec.Builder schemaClassBuilder = TypeSpec.classBuilder(CLASS_NAME)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build());

            addPropertyFields(schemaClassBuilder, schemaNode.get("fields"), new String[0], new String());
            addPropertyAccessors(schemaClassBuilder);

            final JavaFile javaFile = JavaFile.builder(PACKAGE_NAME, schemaClassBuilder.build())
                .addFileComment("\nThis file is auto-generated by SchemaGenerator\n").build();

            try {
                javaFile.writeTo(processingEnv.getFiler());
            } catch (final IOException e) {
                throw new RuntimeException("Unable to write out generated schema file", e);
            }
        }

        return true;
    }

    private void error(final Element e, final String msg, final Object... args)
    {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);
    }

    private static JsonNode parseSchema(final String schemaPath) throws IOException
    {
        final String schema;
        try (final InputStream stream = SchemaGenerator.class.getClassLoader().getResourceAsStream(schemaPath)) {
            schema = IOUtils.toString(stream, StandardCharsets.UTF_8);
        } catch (final IOException e) {
            throw new RuntimeException("Error reading schrma definition from " + schemaPath, e);
        }
        return new ObjectMapper(new YAMLFactory()).readTree(schema);
    }

    private void addPropertyFields(
        final TypeSpec.Builder classBuilder,
        final JsonNode entityDef,
        final String[] path,
        final String parentFieldName
    )
    {
        final Iterator<Entry<String, JsonNode>> propertyIterator = entityDef.fields();

        final boolean isSubfield = path.length > 0;
        final ClassName fieldImplClass = ClassName.get(PACKAGE_NAME, isSubfield ? "SubfieldImpl" : "FieldImpl");
        final Modifier[] fieldOrTypeModifiers = isSubfield ? new Modifier[]{Modifier.PUBLIC, Modifier.FINAL}
            : new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};

        while (propertyIterator.hasNext()) {
            final Entry<String, JsonNode> property = propertyIterator.next();
            final JsonNode fieldAttributes = property.getValue();

            final String propertyName = property.getKey();
            final String ucPropertyName = propertyName.toUpperCase(Locale.US);
            final String sanitizedPropertyName = ucPropertyName.replace('-', '_');

            if (!isSubfield) {
                propertyNames.add(new PropertyNameHelper(propertyName, ucPropertyName, sanitizedPropertyName));
            } else {
                final String subFieldPropertyName = parentFieldName + "." + propertyName;
                final String subFieldUcPropertyName = subFieldPropertyName.toUpperCase(Locale.US);
                final String subFieldSanitizedPropertyName = subFieldUcPropertyName.replace('-', '_');

                propertyNames.add(new PropertyNameHelper(subFieldPropertyName, subFieldUcPropertyName, subFieldSanitizedPropertyName));
            }

            final String fieldType = fieldAttributes.get("type").textValue();

            final String fldEncoding
                = fieldAttributes.hasNonNull("objectEncoding")
                ? (fieldAttributes.get("objectEncoding").textValue().equals("json")
                ? "Field.ObjectEncoding.JSON"
                : "Field.ObjectEncoding.FLATTENED")
                : "Field.ObjectEncoding.JSON";
            final boolean fldIsMultiValued = fieldType.endsWith("[]");
            final boolean fldIsMandatory
                = fieldAttributes.hasNonNull("mandatory")
                ? fieldAttributes.get("mandatory").booleanValue()
                : false;
            final boolean fldIsCaseInsensitive
                = fieldAttributes.hasNonNull("ignoreCase")
                ? fieldAttributes.get("ignoreCase").booleanValue()
                : false;
            final boolean fldIsTokenizedPath
                = fieldAttributes.hasNonNull("tokenizedPath")
                ? fieldAttributes.get("tokenizedPath").booleanValue()
                : false;

            if (!PROPERTY_TYPES.contains(fieldType)) {
                final String fieldName = toProperCase(propertyName) + "Field";
                final String[] newPath = addExtraElement(path, fieldName);
                final String fullName = isSubfield ? parentFieldName + "." + propertyName : propertyName;

                final ClassName fieldClassName = ClassName.get(PACKAGE_NAME, CLASS_NAME, newPath);

                final FieldSpec field = FieldSpec.builder(fieldClassName, sanitizedPropertyName)
                    .addModifiers(fieldOrTypeModifiers).addAnnotation(Nonnull.class)
                    .initializer("new $T()", fieldClassName).build();

                final TypeSpec.Builder fieldClassBuiler = TypeSpec.classBuilder(fieldName)
                    .addModifiers(fieldOrTypeModifiers).superclass(fieldImplClass)
                    .addSuperinterface(isSubfield ? StructuredSubfield.class : StructuredField.class)
                    .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE)
                        .addStatement("super($S, $S, $L, $L, $L, $L, $L$L)",
                                      propertyName,
                                      fieldType,
                                      fldEncoding,
                                      fldIsMultiValued,
                                      fldIsMandatory,
                                      fldIsCaseInsensitive,
                                      fldIsTokenizedPath,
                                      isSubfield ? ", " + path[path.length - 1] + ".this" : "")
                        .build());

                final int endOfTypeName = fieldType.indexOf('[');
                final String refTypeName = endOfTypeName > 0 ? fieldType.substring(0, endOfTypeName) : fieldType;
                final JsonNode subentityDef = typesNode.get(refTypeName);
                addPropertyFields(fieldClassBuiler, subentityDef, newPath, fullName);

                classBuilder.addField(field);
                classBuilder.addType(fieldClassBuiler.build());
            } else {
                final FieldSpec field = FieldSpec
                    .builder(isSubfield ? Subfield.class : Field.class, sanitizedPropertyName)
                    .addModifiers(fieldOrTypeModifiers).addAnnotation(Nonnull.class)
                    .initializer("new $T($S, $S, $L, $L, $L, $L, $L$L)",
                                 fieldImplClass,
                                 propertyName,
                                 fieldType,
                                 fldEncoding,
                                 fldIsMultiValued,
                                 fldIsMandatory,
                                 fldIsCaseInsensitive,
                                 fldIsTokenizedPath,
                                 isSubfield ? ", this" : "")
                    .build();

                classBuilder.addField(field);
            }
        }
    }

    private void addPropertyAccessors(final TypeSpec.Builder classBuilder)
    {
        final ParameterSpec paramName = ParameterSpec.builder(String.class, "fieldName").addModifiers(Modifier.FINAL)
            .build();

        final ParameterSpec paramIgnoreCase = ParameterSpec.builder(TypeName.BOOLEAN, "ignoreCase")
            .addModifiers(Modifier.FINAL).build();

        final MethodSpec.Builder getFieldBuilder = MethodSpec.methodBuilder("getField").addModifiers(Modifier.PUBLIC)
            .addModifiers(Modifier.STATIC).returns(Field.class).addParameter(paramName);

        final MethodSpec.Builder getFieldOverloadBuilder = MethodSpec.methodBuilder("getField")
            .addModifiers(Modifier.PUBLIC).addModifiers(Modifier.STATIC).returns(Field.class)
            .addParameter(paramName).addParameter(paramIgnoreCase).beginControlFlow("if (!ignoreCase)")
            .addStatement("return getField(fieldName)").endControlFlow();

        // Start Switch block.
        getFieldBuilder.beginControlFlow("switch (fieldName)");
        getFieldOverloadBuilder.beginControlFlow("switch (fieldName.toUpperCase(java.util.Locale.ENGLISH))");

        for (final PropertyNameHelper helper : propertyNames) {
            addSwitchCase(getFieldBuilder, helper.propertyName, helper.sanitizedPropertyName);
            addSwitchCase(getFieldOverloadBuilder, helper.ucPropertyName, helper.sanitizedPropertyName);
        }

        addSwitchDefault(getFieldBuilder, "fieldName");
        addSwitchDefault(getFieldOverloadBuilder, "fieldName");

        // End switch block.
        getFieldBuilder.endControlFlow();
        getFieldOverloadBuilder.endControlFlow();

        classBuilder.addMethod(getFieldBuilder.build());
        classBuilder.addMethod(getFieldOverloadBuilder.build());
    }

    private static void addSwitchCase(
        final MethodSpec.Builder builder,
        final String caseValue,
        final String returnValue
    )
    {
        builder.addCode("case $S:\n", caseValue).addStatement("  return $L", returnValue);
    }

    private static void addSwitchDefault(final MethodSpec.Builder builder, final String fieldName)
    {
        builder.addCode("default:\n").addStatement("  throw new FieldNotFoundException($L)", fieldName);
    }

    private static String toProperCase(final String str)
    {
        return StringUtils
            .capitaliseAllWords(str.replace('_', ' ').replace('-', ' ').toLowerCase(Locale.US))
            .replace(" ", "");
    }

    private static String[] addExtraElement(final String[] element, final String extraElement)
    {
        final String[] newPath = Arrays.copyOf(element, element.length + 1);
        newPath[element.length] = extraElement;
        return newPath;
    }
}
