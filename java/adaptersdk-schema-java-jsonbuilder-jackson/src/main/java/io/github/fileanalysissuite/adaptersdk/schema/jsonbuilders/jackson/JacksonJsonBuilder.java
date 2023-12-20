/*
 * Copyright 2022-2024 Open Text.
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
package io.github.fileanalysissuite.adaptersdk.schema.jsonbuilders.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import io.github.fileanalysissuite.adaptersdk.schema.builders.JsonBuilder;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import javax.annotation.Nonnull;

final class JacksonJsonBuilder implements Closeable, Flushable, JsonBuilder
{
    private static final JsonFactory jsonFactory = createJsonFactory();

    private final JsonGenerator jsonGenerator;

    public JacksonJsonBuilder(final Writer memoryWriter)
    {
        try {
            this.jsonGenerator = jsonFactory.createGenerator(memoryWriter);
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void close()
    {
        try {
            jsonGenerator.close();
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void flush()
    {
        try {
            jsonGenerator.flush();
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeStartArray()
    {
        try {
            jsonGenerator.writeStartArray();
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeStartObject()
    {
        try {
            jsonGenerator.writeStartObject();
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeFieldName(final String key)
    {
        try {
            jsonGenerator.writeFieldName(key);
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeBoolean(final boolean value)
    {
        try {
            jsonGenerator.writeBoolean(value);
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeDouble(final double value)
    {
        try {
            jsonGenerator.writeNumber(value);
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeInteger(final long value)
    {
        try {
            jsonGenerator.writeNumber(value);
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeString(final String value)
    {
        try {
            jsonGenerator.writeString(value);
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeEndArray()
    {
        try {
            jsonGenerator.writeEndArray();
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public void writeEndObject()
    {
        try {
            jsonGenerator.writeEndObject();
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Nonnull
    private static JsonFactory createJsonFactory()
    {
        final JsonFactory newJsonFactory = new JsonFactory();
        newJsonFactory.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        newJsonFactory.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
        newJsonFactory.disable(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM);

        return newJsonFactory;
    }
}
