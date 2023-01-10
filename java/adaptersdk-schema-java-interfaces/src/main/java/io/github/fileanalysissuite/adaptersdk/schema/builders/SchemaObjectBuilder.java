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
package io.github.fileanalysissuite.adaptersdk.schema.builders;

import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import java.time.Instant;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface SchemaObjectBuilder
{
    void clearField(Field field);

    void setBooleanFieldValue(Field field, Boolean value);

    void setBooleanFieldValue(Field field, Boolean... values);

    void setBooleanFieldValue(Field field, List<Boolean> values);

    void addBooleanFieldValue(Field field, Boolean value);

    void setDoubleFieldValue(Field field, Double value);

    void setDoubleFieldValue(Field field, Double... values);

    void setDoubleFieldValue(Field field, List<Double> values);

    void addDoubleFieldValue(Field field, Double value);

    void setIntegerFieldValue(Field field, Integer value);

    void setIntegerFieldValue(Field field, Integer... values);

    void setIntegerFieldValue(Field field, List<Integer> values);

    void addIntegerFieldValue(Field field, Integer value);

    void setInstantFieldValue(Field field, Instant value);

    void setInstantFieldValue(Field field, Instant... values);

    void setInstantFieldValue(Field field, List<Instant> values);

    void addInstantFieldValue(Field field, Instant value);

    void setLongFieldValue(Field field, Long value);

    void setLongFieldValue(Field field, Long... values);

    void setLongFieldValue(Field field, List<Long> values);

    void addLongFieldValue(Field field, Long value);

    void setStringFieldValue(Field field, String value);

    void setStringFieldValue(Field field, String... values);

    void setStringFieldValue(Field field, List<String> values);

    void addStringFieldValue(Field field, String value);

    void setJsonFieldValue(Field field, Consumer<JsonBuilder> builder);

    void setJsonFieldValue(Field field, Stream<Consumer<JsonBuilder>> builders);

    void setFlattenedFieldValue(Field field, Consumer<SchemaObjectBuilder> builder);

    void setFlattenedFieldValue(Field field, Stream<Consumer<SchemaObjectBuilder>> builders);
}
