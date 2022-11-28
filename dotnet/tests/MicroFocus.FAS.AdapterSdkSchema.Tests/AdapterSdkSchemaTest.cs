/**
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
using Xunit;

namespace MicroFocus.FAS.AdapterSdkSchema.Tests
{
    public class AdapterSdkSchemaTest
    {

        [Fact]
        public void TestMandatoryField()
        {
            Assert.True(AdapterSdkSchema.GetField("ID").IsMandatory);
        }

        [Fact]
        public void TestIgnoreCaseField()
        {
            Assert.True(AdapterSdkSchema.GetField("TITLE").IsCaseInsensitive);
        }

        [Fact]
        public void TestTokenizedPathField()
        {
            Assert.True(AdapterSdkSchema.GetField("ID_PATH").IsTokenizedPath);
        }

        [Fact]
        public void TestFlattenedField()
        {
            Assert.Equal(ObjectEncoding.Flattened, AdapterSdkSchema.GetField("METADATA_FILES").ObjectEncoding);
        }

        [Fact]
        public void TestJsonField()
        {
            Assert.Equal(ObjectEncoding.Json, AdapterSdkSchema.GetField("accounts", true).ObjectEncoding);
        }

        [Fact]
        public void TestObjectField()
        {
            Assert.Equal("ocr[][]", AdapterSdkSchema.GetField("OCR").FieldType);
        }

        [Fact]
        public void TestNestedMandatoryField()
        {
            Assert.True(AdapterSdkSchema.GetField("METADATA_FILES.CONTENT").IsMandatory);
        }

        [Fact]
        public void TestStringField()
        {
            Assert.Equal("STRING", AdapterSdkSchema.GetField("PARENT_REFERENCE").FieldType);
        }

        [Fact]
        public void TestMultiStringField()
        {
            Assert.True(AdapterSdkSchema.GetField("ADDRESS_CC").IsMultivalue);
        }

        [Fact]
        public void TestLongField()
        {
            Assert.Equal("LONG", AdapterSdkSchema.GetField("ID").FieldType);
        }

        [Fact]
        public void TestObjectParentField()
        {
            Assert.Equal("METADATA_FILES", AdapterSdkSchema.GetField("METADATA_FILES.CONTENT").ParentField.FieldName);
        }

    }
}
