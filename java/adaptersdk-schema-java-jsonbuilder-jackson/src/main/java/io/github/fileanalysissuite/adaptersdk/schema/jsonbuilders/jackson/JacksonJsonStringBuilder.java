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

import io.github.fileanalysissuite.adaptersdk.schema.builders.JsonBuilder;
import jakarta.annotation.Nonnull;
import java.io.StringWriter;
import java.util.function.Consumer;

public final class JacksonJsonStringBuilder
{
    private JacksonJsonStringBuilder()
    {
    }

    @Nonnull
    public static String buildJsonString(final Consumer<JsonBuilder> director)
    {
        final StringWriter stringWriter = new StringWriter();
        try (final JacksonJsonBuilder jsonBuilder = new JacksonJsonBuilder(stringWriter)) {
            director.accept(jsonBuilder);
        }

        return stringWriter.toString();
    }
}
