/**
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
using System;

namespace MicroFocus.FAS.AdapterSdkSchema
{
    public interface IJsonBuilder
    {
        void WriteStartArray();

        void WriteStartObject();

        void WriteFieldName(string key);

        void WriteBoolean(bool value);

        void WriteDouble(double value);

        void WriteInteger(int value);

        void WriteString(string value);

        void WriteEndArray();

        void WriteEndObject();
    }
}
