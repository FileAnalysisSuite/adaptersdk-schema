/**
 * Copyright 2022-2023 Open Text.
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
using System.IO;
using System.Text;
using System.Text.Json;
using MicroFocus.FAS.AdapterSdkSchema.SchemaObjectBuilders;

namespace MicroFocus.FAS.AdapterSdkSchema.JsonBuilders.System
{
    public sealed class SystemJsonStringBuilder : IJsonStringBuilder
    {
        public SystemJsonStringBuilder()
        {
        }

        public string BuildJsonString(Action<IJsonBuilder> director)
        {
            using (MemoryStream stream = new MemoryStream())
            using (Utf8JsonWriter jsonWriter = new Utf8JsonWriter(stream))
            {
                SystemJsonBuilder jsonBuilder = new SystemJsonBuilder(jsonWriter);
                director.Invoke(jsonBuilder);
                jsonWriter.Flush();
                return Encoding.UTF8.GetString(stream.ToArray());
            }
        }
    }
}
