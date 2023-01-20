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

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

final class SchemaGeneratorHelper
{
    static final String PACKAGE_NAME = "io.github.fileanalysissuite.adaptersdk.schema";
    static final String CLASS_NAME = "AdapterSdkSchema";
    static final Set<String> PROPERTY_TYPES
        = new HashSet<>(Arrays.asList(
            "STRING", "FULLTEXT", "LONG", "DOUBLE", "INTEGER", "BOOLEAN", "DATETIME",
            "STRING[]", "FULLTEXT[]", "LONG[]", "DOUBLE[]", "INTEGER[]", "BOOLEAN[]", "DATETIME[]"));

    private SchemaGeneratorHelper() {}

    static JsonNode parseSchemaDefinition()
    {
        try {
            return parseSchema("schemaDefinition.json.yaml");
        } catch (final IOException e) {
            throw new RuntimeException("Unable to parse schema", e);
        }
    }

    static JsonNode parseSchema(final String schemaPath) throws IOException
    {
        final String schema;
        try (final InputStream stream = SchemaObjectBuilderGenerator.class.getResourceAsStream(schemaPath)) {
            schema = IOUtils.toString(stream, StandardCharsets.UTF_8);
        } catch (final IOException e) {
            throw new RuntimeException("Error reading schema definition from " + schemaPath, e);
        }
        return new ObjectMapper(new YAMLFactory()).readTree(schema);
    }

    static String toProperCase(final String str)
    {
        return StringUtils
            .capitaliseAllWords(str.replace('_', ' ').replace('-', ' ').toLowerCase(Locale.US))
            .replace(" ", "");
    }

    static String toFieldNameCase(final String str)
    {
        return StringUtils.lowercaseFirstLetter(toProperCase(str));
    }

    static String[] addExtraElement(final String[] element, final String extraElement)
    {
        final String[] newPath = Arrays.copyOf(element, element.length + 1);
        newPath[element.length] = extraElement;
        return newPath;
    }
}
