/*
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
package io.github.fileanalysissuite.adaptersdk.schema.schemaobjectbuilders;

import io.github.fileanalysissuite.adaptersdk.schema.builders.JsonBuilder;
import io.github.fileanalysissuite.adaptersdk.schema.builders.SchemaObjectBuilder;
import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

final class StringMapSchemaObjectBuilderImpl implements SchemaObjectBuilder
{
    private final Map<String, List<String>> metadata;
    private final JsonStringBuilder jsonStringBuilder;
    private final String prefix;

    public StringMapSchemaObjectBuilderImpl(
        final Map<String, List<String>> metadata,
        final JsonStringBuilder jsonStringBuilder
    )
    {
        this(metadata, jsonStringBuilder, "");
    }

    private StringMapSchemaObjectBuilderImpl(
        final Map<String, List<String>> metadata,
        final JsonStringBuilder jsonStringBuilder,
        final String prefix
    )
    {
        this.metadata = metadata;
        this.jsonStringBuilder = jsonStringBuilder;
        this.prefix = prefix;
    }

    @Override
    public void clearField(final Field field)
    {
        final String metadataKey = getMetadataKey(field);

        if (field.getObjectEncoding() == Field.ObjectEncoding.FLATTENED) {
            metadata.keySet().removeIf(key -> key.startsWith(metadataKey + "_"));
        } else {
            metadata.remove(metadataKey);
        }
    }

    @Override
    public void setBooleanFieldValue(final Field field, final boolean value)
    {
        metadata.put(getMetadataKey(field),
                     Collections.singletonList(Boolean.toString(value)));
    }

    @Override
    public void setBooleanFieldValue(final Field field, final boolean... values)
    {
        final ArrayList<String> stringValues = new ArrayList<>();
        for (final boolean value : values) {
            stringValues.add(Boolean.toString(value));
        }

        metadata.put(getMetadataKey(field), stringValues);
    }

    @Override
    public void setBooleanFieldValue(final Field field, final List<Boolean> values)
    {
        metadata.put(getMetadataKey(field),
                     values.stream().map(value -> value.toString()).collect(Collectors.toList()));
    }

    @Override
    public void addBooleanFieldValue(final Field field, final boolean value)
    {
        addStringFieldValueImpl(field, Boolean.toString(value));
    }

    @Override
    public void setDoubleFieldValue(final Field field, final double value)
    {
        metadata.put(getMetadataKey(field),
                     Collections.singletonList(Double.toString(value)));
    }

    @Override
    public void setDoubleFieldValue(final Field field, final double... values)
    {
        final ArrayList<String> stringValues = new ArrayList<>();
        for (final double value : values) {
            stringValues.add(Double.toString(value));
        }

        metadata.put(getMetadataKey(field), stringValues);
    }

    @Override
    public void setDoubleFieldValue(final Field field, final List<Double> values)
    {
        metadata.put(getMetadataKey(field),
                     values.stream().map(value -> value.toString()).collect(Collectors.toList()));
    }

    @Override
    public void addDoubleFieldValue(final Field field, final double value)
    {
        addStringFieldValueImpl(field, Double.toString(value));
    }

    @Override
    public void setIntegerFieldValue(final Field field, final int value)
    {
        metadata.put(getMetadataKey(field),
                     Collections.singletonList(Integer.toString(value)));
    }

    @Override
    public void setIntegerFieldValue(final Field field, final int... values)
    {
        final ArrayList<String> stringValues = new ArrayList<>();
        for (final int value : values) {
            stringValues.add(Integer.toString(value));
        }

        metadata.put(getMetadataKey(field), stringValues);
    }

    @Override
    public void setIntegerFieldValue(final Field field, final List<Integer> values)
    {
        metadata.put(getMetadataKey(field),
                     values.stream().map(value -> value.toString()).collect(Collectors.toList()));
    }

    @Override
    public void addIntegerFieldValue(final Field field, final int value)
    {
        addStringFieldValueImpl(field, Integer.toString(value));
    }

    @Override
    public void setInstantFieldValue(final Field field, final Instant value)
    {
        metadata.put(getMetadataKey(field),
                     Collections.singletonList(InstantFunctions.toEpochSecondsString(value)));
    }

    @Override
    public void setInstantFieldValue(final Field field, final Instant... values)
    {
        metadata.put(getMetadataKey(field),
                     Stream.of(values).map(InstantFunctions::toEpochSecondsString).collect(Collectors.toList()));
    }

    @Override
    public void setInstantFieldValue(final Field field, final List<Instant> values)
    {
        metadata.put(getMetadataKey(field),
                     values.stream().map(InstantFunctions::toEpochSecondsString).collect(Collectors.toList()));
    }

    @Override
    public void addInstantFieldValue(final Field field, final Instant value)
    {
        addStringFieldValueImpl(field, InstantFunctions.toEpochSecondsString(value));
    }

    @Override
    public void setLongFieldValue(final Field field, final long value)
    {
        metadata.put(getMetadataKey(field),
                     Collections.singletonList(Long.toString(value)));
    }

    @Override
    public void setLongFieldValue(final Field field, final long... values)
    {
        final ArrayList<String> stringValues = new ArrayList<>();
        for (final long value : values) {
            stringValues.add(Long.toString(value));
        }

        metadata.put(getMetadataKey(field), stringValues);
    }

    @Override
    public void setLongFieldValue(final Field field, final List<Long> values)
    {
        metadata.put(getMetadataKey(field),
                     values.stream().map(value -> value.toString()).collect(Collectors.toList()));
    }

    @Override
    public void addLongFieldValue(final Field field, final long value)
    {
        addStringFieldValueImpl(field, Long.toString(value));
    }

    @Override
    public void setStringFieldValue(final Field field, final String value)
    {
        metadata.put(getMetadataKey(field),
                     Collections.singletonList(value));
    }

    @Override
    public void setStringFieldValue(final Field field, final String... values)
    {
        metadata.put(getMetadataKey(field), Arrays.asList(values));
    }

    @Override
    public void setStringFieldValue(final Field field, final List<String> values)
    {
        metadata.put(getMetadataKey(field), values);
    }

    @Override
    public void addStringFieldValue(final Field field, final String value)
    {
        addStringFieldValueImpl(field, value);
    }

    @Override
    public void setJsonFieldValue(final Field field, final Consumer<JsonBuilder> director)
    {
        metadata.put(getMetadataKey(field),
                     Collections.singletonList(jsonStringBuilder.buildJsonString(director)));
    }

    @Override
    public void setJsonFieldValue(final Field field, final Stream<Consumer<JsonBuilder>> directors)
    {
        metadata.put(getMetadataKey(field),
                     directors.map(jsonStringBuilder::buildJsonString).collect(Collectors.toList()));
    }

    @Override
    public void setFlattenedFieldValue(final Field field, final Consumer<SchemaObjectBuilder> director)
    {
        final String nextLevelPrefix = (field == null)
            ? prefix + "0_"
            : prefix + field.getFieldName() + (field.isMultivalue() ? "_0_" : "__");

        director.accept(new StringMapSchemaObjectBuilderImpl(metadata, jsonStringBuilder, nextLevelPrefix));
    }

    @Override
    public void setFlattenedFieldValue(final Field field, final Stream<Consumer<SchemaObjectBuilder>> directors)
    {
        final String basePrefix = (field == null)
            ? prefix
            : prefix + field.getFieldName() + "_";

        final Iterable<Consumer<SchemaObjectBuilder>> directorsIt = directors::iterator;

        int i = 0;
        for (final Consumer<SchemaObjectBuilder> director : directorsIt) {
            final String nextLevelPrefix = basePrefix + i + "_";
            director.accept(new StringMapSchemaObjectBuilderImpl(metadata, jsonStringBuilder, nextLevelPrefix));
            i++;
        }
    }

    @Nonnull
    private String getMetadataKey(final Field field)
    {
        if (prefix.isEmpty()) {
            assert field.getParentField() == null;
            return field.getFieldName();
        } else {
            assert field.getParentField() != null;
            return prefix + field.getFieldName();
        }
    }

    private void addStringFieldValueImpl(final Field field, final String newValue)
    {
        final String metadataKey = getMetadataKey(field);
        final List<String> currentList = metadata.get(metadataKey);

        if (currentList instanceof ArrayList) {
            currentList.add(newValue);
        } else {
            final ArrayList<String> newList = (currentList == null)
                ? new ArrayList<>()
                : new ArrayList<>(currentList);

            newList.add(newValue);

            metadata.put(metadataKey, newList);
        }
    }
}
