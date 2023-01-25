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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.codehaus.plexus.util.StringUtils;

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
    public void setIntegerFieldValue(final Field field, final Integer value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setIntegerFieldValue(final Field field, final Integer... values)
    {
        document.put(field.getFieldName(), Arrays.asList(values));
    }

    @Override
    public void setIntegerFieldValue(final Field field, final List<Integer> values)
    {
        document.put(field.getFieldName(), values);
    }

    @Override
    public void addIntegerFieldValue(final Field field, final Integer value)
    {
        Object currentValue = document.get(field.getFieldName());
        if(currentValue == null) {
            currentValue = new ArrayList<Double>();
        }
        document.put(field.getFieldName(), ((ArrayList<Integer>)currentValue).add(value));
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
        final int numberOfDimensions = getNumberOfDimensions(field);
        if (numberOfDimensions <= 1) {
            putFieldValues(field, builder, "" + 0);
        }
        else {
            // multi-dimensional
            for (int i = 0; i <= numberOfDimensions; i++) {
                putFieldValues(field, builder, i + "_0");
            }
        }
    }

    private static int getNumberOfDimensions(final Field field)
    {
        final String fieldType = field.getFieldType();
        final int endOfTypeDimension = fieldType.lastIndexOf('[');
        //final String fieldTypeValue = endOfTypeDimension > 0 ? fieldType.substring(0, endOfTypeDimension) : fieldType;
        return endOfTypeDimension > 0 ? StringUtils.countMatches(fieldType, "[]") : 0;
    }

    @Override
    public void setFlattenedFieldValue(final Field field, final Stream<Consumer<SchemaObjectBuilder>> builders)
    {
        // TODO : check this
        final int numberOfDimensions = getNumberOfDimensions(field);
        if (numberOfDimensions <= 1) {
            int counter = 0;
            Iterator<Consumer<SchemaObjectBuilder>> iter = builders.iterator();
            while (iter.hasNext())
            {
                putFieldValues(field, iter.next(), "" + counter);
                counter++;
            }
        }
        else {
            // multi-dimensional
            for (int i = 0; i <= numberOfDimensions; i++) {
                int counter = 0;
                Iterator<Consumer<SchemaObjectBuilder>> iter = builders.iterator();
                while (iter.hasNext())
                {
                    putFieldValues(field, iter.next(), i + "_" + counter);
                    counter++;
                }
            }
        }
    }

    private void putFieldValues(final Field field, final Consumer<SchemaObjectBuilder> builder, final String counter)
    {
        final Map<String, Object> nextLevel = new HashMap<>();
        final MapSchemaObjectBuilder nextLevelBuilder = new MapSchemaObjectBuilder(nextLevel);
        builder.accept(nextLevelBuilder);
        final Set<Entry<String, Object>> entrySet = nextLevel.entrySet();
        for ( final Map.Entry<String,Object> entry : entrySet )
        {
            document.put(field.getFieldName() + "_" + counter + "_" + entry.getKey(), entry.getValue());
        }
    }

}
