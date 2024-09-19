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
    internal class SubfieldImpl : FieldImpl, ISubfield
    {
        private readonly IField parentField;

        public SubfieldImpl(
            string fieldName,
            string fieldType,
            ObjectEncoding? objectEncoding,
            bool multivalue,
            bool mandatory,
            bool caseInsensitive,
            bool tokenizedPath,
            IField parentField
        )
            : base(fieldName, fieldType, objectEncoding, multivalue, mandatory, caseInsensitive, tokenizedPath)
        {
            this.parentField = parentField;
        }

        public override IField ParentField => parentField;
    }
}
