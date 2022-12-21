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

    @Override
    public void addStringFieldValue(final Field field, final String value)
    {
        Object currentValue = document.get(field.getFieldName());
        if(currentValue == null) {
            currentValue = new ArrayList<String>();
        }
        document.put(field.getFieldName(), ((ArrayList<String>)currentValue).add(value));
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
    public void setBooleanFieldValue(final Field field, final Boolean value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setBooleanFieldValue(final Field field, final Boolean... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setBooleanFieldValue(final Field field, final List<Boolean> values)
    {
        document.put(field.getFieldName(), values);
    }

    @Override
    public void addBooleanFieldValue(final Field field, final Boolean value)
    {
        Object currentValue = document.get(field.getFieldName());
        if(currentValue == null) {
            currentValue = new ArrayList<Boolean>();
        }
        document.put(field.getFieldName(), ((ArrayList<Boolean>)currentValue).add(value));
    }

    @Override
    public void setDoubleFieldValue(final Field field, final Double value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setDoubleFieldValue(final Field field, final Double... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setDoubleFieldValue(final Field field, final List<Double> values)
    {
        document.put(field.getFieldName(), values);
    }

    @Override
    public void addDoubleFieldValue(final Field field, final Double value)
    {
        Object currentValue = document.get(field.getFieldName());
        if(currentValue == null) {
            currentValue = new ArrayList<Double>();
        }
        document.put(field.getFieldName(), ((ArrayList<Double>)currentValue).add(value));
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

    @Override
    public void addInstantFieldValue(final Field field, final Instant value)
    {
        Object currentValue = document.get(field.getFieldName());
        if(currentValue == null) {
            currentValue = new ArrayList<Instant>();
        }
        document.put(field.getFieldName(), ((ArrayList<Instant>)currentValue).add(value));
    }

    @Override
    public void setLongFieldValue(final Field field, final Long value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setLongFieldValue(final Field field, final Long... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setLongFieldValue(final Field field, final List<Long> values)
    {
        document.put(field.getFieldName(), values);
    }

    @Override
    public void addLongFieldValue(final Field field, final Long value)
    {
        Object currentValue = document.get(field.getFieldName());
        if(currentValue == null) {
            currentValue = new ArrayList<Long>();
        }
        document.put(field.getFieldName(), ((ArrayList<Long>)currentValue).add(value));
    }

    @Override
    public void setFlattenedFieldValue(final Field field, final Consumer<SchemaObjectBuilder> builder)
    {
        // clear and add
        final Map<String, Object> nextLevel = new HashMap<>();
        final MapSchemaObjectBuilder nextLevelBuilder = new MapSchemaObjectBuilder(nextLevel);
        builder.accept(nextLevelBuilder);
        for ( final Map.Entry<String,Object> entry : nextLevel.entrySet() )
        {
            document.put(field.getFieldName() + "_0_" + entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void setFlattenedFieldValue(final Field field, final Stream<Consumer<SchemaObjectBuilder>> builders)
    {
        final Map<String, Object> nextLevel = new HashMap<>();
        int counter = 0;
        for ( final Map.Entry<String,Object> entry : nextLevel.entrySet() )
        {
            document.put(
                field.getFieldName() + "_" + counter++ + "_" + entry.getKey(),
                builders.map(builder -> {
                    final MapSchemaObjectBuilder nextLevelBuilder = new MapSchemaObjectBuilder(nextLevel);
                    builder.accept(nextLevelBuilder);
                    return nextLevelBuilder;
                }).collect(Collectors.toList())
            );
        }

    }
}
