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
package io.github.fileanalysissuite.adaptersdk.schema.builders;

import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import java.time.Instant;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface SchemaObjectBuilder
{
    void clearField(Field field);

    void setBooleanFieldValue(Field field, boolean value);

    void setBooleanFieldValue(Field field, boolean... values);

    void setBooleanFieldValue(Field field, List<Boolean> values);

    void addBooleanFieldValue(Field field, boolean value);

    void setDoubleFieldValue(Field field, double value);

    void setDoubleFieldValue(Field field, double... values);

    void setDoubleFieldValue(Field field, List<Double> values);

    void addDoubleFieldValue(Field field, double value);

    void setIntegerFieldValue(Field field, int value);

    void setIntegerFieldValue(Field field, int... values);

    void setIntegerFieldValue(Field field, List<Integer> values);

    void addIntegerFieldValue(Field field, int value);

    void setInstantFieldValue(Field field, Instant value);

    void setInstantFieldValue(Field field, Instant... values);

    void setInstantFieldValue(Field field, List<Instant> values);

    void addInstantFieldValue(Field field, Instant value);

    void setLongFieldValue(Field field, long value);

    void setLongFieldValue(Field field, long... values);

    void setLongFieldValue(Field field, List<Long> values);

    void addLongFieldValue(Field field, long value);

    void setStringFieldValue(Field field, String value);

    void setStringFieldValue(Field field, String... values);

    void setStringFieldValue(Field field, List<String> values);

    void addStringFieldValue(Field field, String value);

    void setJsonFieldValue(Field field, Consumer<JsonBuilder> director);

    void setJsonFieldValue(Field field, Stream<Consumer<JsonBuilder>> directors);

    void setFlattenedFieldValue(Field field, Consumer<SchemaObjectBuilder> director);

    void setFlattenedFieldValue(Field field, Stream<Consumer<SchemaObjectBuilder>> directors);
}
