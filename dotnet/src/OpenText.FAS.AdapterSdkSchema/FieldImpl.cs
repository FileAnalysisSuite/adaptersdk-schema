/**
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
namespace OpenText.FAS.AdapterSdkSchema
{
    internal class FieldImpl : IField
    {
        private readonly string fieldName;
        private readonly string fieldType;
        private readonly ObjectEncoding? objectEncoding;
        private readonly bool multivalue;
        private readonly bool mandatory;
        private readonly bool caseInsensitive;
        private readonly bool tokenizedPath;

        public FieldImpl(
            string fieldName,
            string fieldType,
            ObjectEncoding? objectEncoding,
            bool multivalue,
            bool mandatory,
            bool caseInsensitive,
            bool tokenizedPath
        )
        {
            this.fieldName = fieldName;
            this.fieldType = fieldType;
            this.objectEncoding = objectEncoding;
            this.multivalue = multivalue;
            this.mandatory = mandatory;
            this.caseInsensitive = caseInsensitive;
            this.tokenizedPath = tokenizedPath;
        }

        public string FieldName => fieldName;

        public string FieldType => fieldType;

        public ObjectEncoding? ObjectEncoding => objectEncoding;

        public virtual IField ParentField => null;

        public bool IsMultivalue => multivalue;

        public bool IsMandatory => mandatory;

        public bool IsCaseInsensitive => caseInsensitive;

        public bool IsTokenizedPath => tokenizedPath;
    }
}
