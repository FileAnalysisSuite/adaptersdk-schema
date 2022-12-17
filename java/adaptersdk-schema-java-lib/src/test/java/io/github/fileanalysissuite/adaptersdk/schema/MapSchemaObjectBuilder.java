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
import java.util.Collections;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setStringFieldValue(final Field field, final List<String> values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addStringFieldValue(final Field field, final String value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setInstantFieldValue(final Field field, final Instant value)
    {
        document.put(field.getFieldName(), value);
    }

    @Override
    public void setJsonFieldValue(final Field field, final Consumer<JsonBuilder> builder)
    {
        final JacksonJsonBuilder jsonBuilder = new JacksonJsonBuilder(null);
        builder.accept(jsonBuilder);

        document.put(field.getFieldName(), jsonBuilder.encode());
    }

    @Override
    public void setJsonFieldValue(final Field field, final Stream<Consumer<JsonBuilder>> builders)
    {
        document.put(
            field.getFieldName(),
            builders.map(builder -> {
                final JacksonJsonBuilder jsonBuilder = new JacksonJsonBuilder(null);
                builder.accept(jsonBuilder);
                return jsonBuilder.encode();
            }).collect(Collectors.toList()));
    }

    @Override
    public void setBooleanFieldValue(Field field, Boolean value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBooleanFieldValue(Field field, Boolean... values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBooleanFieldValue(Field field, List<Boolean> values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addBooleanFieldValue(Field field, Boolean value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDoubleFieldValue(Field field, Double value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDoubleFieldValue(Field field, Double... values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDoubleFieldValue(Field field, List<Double> values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addDoubleFieldValue(Field field, Double value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setInstantFieldValue(Field field, Instant... values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setInstantFieldValue(Field field, List<Instant> values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addInstantFieldValue(Field field, Instant value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setLongFieldValue(Field field, Long value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setLongFieldValue(Field field, Long... values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setLongFieldValue(Field field, List<Long> values)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addLongFieldValue(Field field, Long value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
