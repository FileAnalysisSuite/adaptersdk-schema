/*
 * Copyright 2022 EntIT Software LLC, a Micro Focus company.
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

import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import java.time.Instant;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface SchemaObjectBuilder
{
    void clearField(Field field);

    void setStringFieldValue(Field field, String value);

    void setFieldValue(Field field, String... values);

    void setFieldValue(Field field, List<String> values);

    void addFieldValue(Field field, String value);

    void setFieldValue(Field field, Instant value);

    void setFieldValue(Field field, Consumer<JsonBuilder> builder);

    void setJsonFieldValue(Field field, Stream<Consumer<JsonBuilder>> builders);
}
