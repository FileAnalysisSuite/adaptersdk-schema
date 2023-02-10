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
using System.Text;
using System.Text.Json;

namespace MicroFocus.FAS.AdapterSdkSchema
{
    internal sealed class SystemJsonBuilder : IJsonBuilder
    {
        private readonly MemoryStream _stream;
        private readonly Utf8JsonWriter _jsonWriter;

        public SystemJsonBuilder()
        {
            _stream = new MemoryStream();
            _jsonWriter = new Utf8JsonWriter(_stream);
        }
        public void WriteBoolean(bool value)
        {
            _jsonWriter.WriteBooleanValue(value);
        }

        public void WriteEndArray()
        {
            _jsonWriter.WriteEndArray();
        }

        public void WriteNull()
        {
            _jsonWriter.WriteNullValue();
        }

        public void WriteNumber(long value)
        {
            _jsonWriter.WriteNumberValue(value);
        }

        public void WriteStartArray()
        {
            _jsonWriter.WriteStartArray();
        }

        public void WriteString(string text)
        {
            _jsonWriter.WriteStringValue(text);
        }

        public void WriteDouble(double value)
        {
            _jsonWriter.WriteNumberValue(value);
        }

        public void WriteEndObject()
        {
            _jsonWriter.WriteEndObject();
        }

        public void WriteFieldName(string key)
        {
            _jsonWriter.WritePropertyName(key);
        }

        public void WriteInteger(int value)
        {
            _jsonWriter.WriteNumberValue(value);
        }

        public void WriteStartObject()
        {
            _jsonWriter.WriteStartObject();
        }

        public string Encode()
        {
            _jsonWriter.Flush();
            return Encoding.UTF8.GetString(_stream.ToArray());
        }
    }
}
