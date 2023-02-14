/*
 * Copyright 2022-2023 Micro Focus or one of its affiliates.
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
package io.github.fileanalysissuite.adaptersdk.schema;

import io.github.fileanalysissuite.adaptersdk.schema.builders.JsonBuilder;
import io.github.fileanalysissuite.adaptersdk.schema.builders.SchemaObjectBuilder;
import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MapSchemaObjectBuilder implements SchemaObjectBuilder
{
    private final Map<String, Object> document;

    public MapSchemaObjectBuilder(final Map<String, Object> document)
    {
        this.document = document;
    }

    @Override
    public void clearField(final Field field)
    {
        document.remove(field.getFieldName());
    }

    @Override
    public void setStringFieldValue(final Field field, final String value)
    {
        document.put(field.getFieldName(),
                     field.isMultivalue() ? Collections.singletonList(value) : value);
    }

    @Override
    public void setStringFieldValue(final Field field, final String... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setStringFieldValue(final Field field, final List<String> values)
    {
        document.put(field.getFieldName(), values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addStringFieldValue(final Field field, final String value)
    {
        final Object currentValue = document.get(field.getFieldName());
        final List<String> list = new ArrayList<String>();
        if (currentValue == null) {
            list.add(value);
        } else if (currentValue instanceof List) {
            list.addAll((List<? extends String>) currentValue);
            list.add(value);
        } else {
            list.add((String) currentValue);
            list.add(value);
        }
        document.put(field.getFieldName(), list);
    }

    @Override
    public void setInstantFieldValue(final Field field, final Instant value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setJsonFieldValue(final Field field, final Consumer<JsonBuilder> builder)
    {
        final JacksonJsonBuilder jsonBuilder = new JacksonJsonBuilder();
        builder.accept(jsonBuilder);

        document.put(field.getFieldName(), jsonBuilder.encode());
    }

    @Override
    public void setJsonFieldValue(final Field field, final Stream<Consumer<JsonBuilder>> builders)
    {
        document.put(
            field.getFieldName(),
            builders.map(builder -> {
                final JacksonJsonBuilder jsonBuilder = new JacksonJsonBuilder();
                builder.accept(jsonBuilder);
                return jsonBuilder.encode();
            }).collect(Collectors.toList()));
    }

    @Override
    public void setBooleanFieldValue(final Field field, final boolean value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setBooleanFieldValue(final Field field, final boolean... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setBooleanFieldValue(final Field field, final List<Boolean> values)
    {
        document.put(field.getFieldName(), values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addBooleanFieldValue(final Field field, final boolean value)
    {
        final Object currentValue = document.get(field.getFieldName());
        final List<Boolean> list = new ArrayList<Boolean>();
        if (currentValue == null) {
            list.add(value);
        } else if (currentValue instanceof List) {
            list.addAll((List<? extends Boolean>) currentValue);
            list.add(value);
        } else {
            list.add((Boolean) currentValue);
            list.add(value);
        }
        document.put(field.getFieldName(), list);
    }

    @Override
    public void setDoubleFieldValue(final Field field, final double value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setDoubleFieldValue(final Field field, final double... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setDoubleFieldValue(final Field field, final List<Double> values)
    {
        document.put(field.getFieldName(), values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addDoubleFieldValue(final Field field, final double value)
    {
        final Object currentValue = document.get(field.getFieldName());
        final List<Double> list = new ArrayList<Double>();
        if (currentValue == null) {
            list.add(value);
        } else if (currentValue instanceof List) {
            list.addAll((List<? extends Double>) currentValue);
            list.add(value);
        } else {
            list.add((Double) currentValue);
            list.add(value);
        }
        document.put(field.getFieldName(), list);
    }

    @Override
    public void setInstantFieldValue(final Field field, final Instant... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setInstantFieldValue(final Field field, final List<Instant> values)
    {
        document.put(field.getFieldName(), values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addInstantFieldValue(final Field field, final Instant value)
    {
        final Object currentValue = document.get(field.getFieldName());
        final List<Instant> list = new ArrayList<Instant>();
        if (currentValue == null) {
            list.add(value);
        } else if (currentValue instanceof List) {
            list.addAll((List<? extends Instant>) currentValue);
            list.add(value);
        } else {
            list.add((Instant) currentValue);
            list.add(value);
        }
        document.put(field.getFieldName(), list);
    }

    @Override
    public void setIntegerFieldValue(final Field field, final int value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setIntegerFieldValue(final Field field, final int... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setIntegerFieldValue(final Field field, final List<Integer> values)
    {
        document.put(field.getFieldName(), values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addIntegerFieldValue(final Field field, final int value)
    {
        final Object currentValue = document.get(field.getFieldName());
        final List<Integer> list = new ArrayList<Integer>();
        if (currentValue == null) {
            list.add(value);
        } else if (currentValue instanceof List) {
            list.addAll((List<? extends Integer>) currentValue);
            list.add(value);
        } else {
            list.add((Integer) currentValue);
            list.add(value);
        }
        document.put(field.getFieldName(), list);
    }

    @Override
    public void setLongFieldValue(final Field field, final long value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setLongFieldValue(final Field field, final long... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setLongFieldValue(final Field field, final List<Long> values)
    {
        document.put(field.getFieldName(), values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addLongFieldValue(final Field field, final long value)
    {
        final Object currentValue = document.get(field.getFieldName());
        final List<Long> list = new ArrayList<Long>();
        if (currentValue == null) {
            list.add(value);
        } else if (currentValue instanceof List) {
            list.addAll((List<? extends Long>) currentValue);
            list.add(value);
        } else {
            list.add((Long) currentValue);
            list.add(value);
        }
        document.put(field.getFieldName(), list);
    }

    @Override
    public void setFlattenedFieldValue(final Field field, final Consumer<SchemaObjectBuilder> director)
    {
        final String prefix = (field == null ? "" : field.getFieldName() + "_") + "0_";
        putFieldValues(prefix, director);
    }

    @Override
    public void setFlattenedFieldValue(final Field field, final Stream<Consumer<SchemaObjectBuilder>> directors)
    {
        final String basePrefix = field == null ? "" : field.getFieldName() + "_";

        final Iterable<Consumer<SchemaObjectBuilder>> directorsIt = directors::iterator;

        int i = 0;
        for (final Consumer<SchemaObjectBuilder> director : directorsIt) {
            final String prefix = basePrefix + i + "_";
            putFieldValues(prefix, director);
            i++;
        }
    }

    private void putFieldValues(final String prefix, final Consumer<SchemaObjectBuilder> director)
    {
        final Map<String, Object> nextLevel = new HashMap<>();
        final MapSchemaObjectBuilder nextLevelBuilder = new MapSchemaObjectBuilder(nextLevel);
        director.accept(nextLevelBuilder);
        final Set<Entry<String, Object>> entrySet = nextLevel.entrySet();
        for (final Map.Entry<String, Object> entry : entrySet) {
            document.put(prefix + entry.getKey(), entry.getValue());
        }
    }
}
