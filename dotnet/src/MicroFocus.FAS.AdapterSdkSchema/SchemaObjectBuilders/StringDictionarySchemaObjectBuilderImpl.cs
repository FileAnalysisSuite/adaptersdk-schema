/**
 * Copyright 2022-2025 Open Text.
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
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Linq;

namespace MicroFocus.FAS.AdapterSdkSchema.SchemaObjectBuilders
{
    internal sealed class StringDictionarySchemaObjectBuilderImpl : ISchemaObjectBuilder
    {
        private readonly IDictionary<string, IEnumerable<string>> _metadata;
        private readonly JsonStringBuilder _jsonStringBuilder;
        private readonly string _prefix;

        public StringDictionarySchemaObjectBuilderImpl(
            IDictionary<string, IEnumerable<string>> metadata,
            JsonStringBuilder jsonStringBuilder)
                : this(metadata, jsonStringBuilder, "")
        {
        }

        private StringDictionarySchemaObjectBuilderImpl(
            IDictionary<string, IEnumerable<string>> metadata,
            JsonStringBuilder jsonStringBuilder,
            string prefix)
        {
            _metadata = metadata;
            _jsonStringBuilder = jsonStringBuilder;
            _prefix = prefix;
        }

        public void ClearField(IField field)
        {
            string metadataKey = GetMetadataKey(field);

            if (field.ObjectEncoding == ObjectEncoding.Flattened)
            {
                var keysToRemove = _metadata.Keys.Where(key => key.StartsWith(metadataKey + "_")).ToList();
                keysToRemove.ForEach(key => _metadata.Remove(key));
            }
            else
            {
                _metadata.Remove(metadataKey);
            }
        }

        public void SetBooleanFieldValue(IField field, bool value)
        {
            _metadata[GetMetadataKey(field)] = new[] { value.ToLowerCaseString() };
        }

        public void SetBooleanFieldValue(IField field, params bool[] values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(BooleanExtension.ToLowerCaseString).ToList();
        }

        public void SetBooleanFieldValue(IField field, IEnumerable<bool> values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(BooleanExtension.ToLowerCaseString).ToList();
        }

        public void AddBooleanFieldValue(IField field, bool value)
        {
            AddStringFieldValueImpl(field, value.ToLowerCaseString());
        }

        public void SetDoubleFieldValue(IField field, double value)
        {
            _metadata[GetMetadataKey(field)] = new[] { value.ToString(NumberFormatInfo.InvariantInfo) };
        }

        public void SetDoubleFieldValue(IField field, params double[] values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(value => value.ToString(NumberFormatInfo.InvariantInfo)).ToList();
        }

        public void SetDoubleFieldValue(IField field, IEnumerable<double> values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(value => value.ToString(NumberFormatInfo.InvariantInfo)).ToList();
        }

        public void AddDoubleFieldValue(IField field, double value)
        {
            AddStringFieldValueImpl(field, value.ToString(NumberFormatInfo.InvariantInfo));
        }

        public void SetIntegerFieldValue(IField field, int value)
        {
            _metadata[GetMetadataKey(field)] = new[] { value.ToString(NumberFormatInfo.InvariantInfo) };
        }

        public void SetIntegerFieldValue(IField field, params int[] values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(value => value.ToString(NumberFormatInfo.InvariantInfo)).ToList();
        }

        public void SetIntegerFieldValue(IField field, IEnumerable<int> values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(value => value.ToString(NumberFormatInfo.InvariantInfo)).ToList();
        }

        public void AddIntegerFieldValue(IField field, int value)
        {
            AddStringFieldValueImpl(field, value.ToString(NumberFormatInfo.InvariantInfo));
        }

        public void SetInstantFieldValue(IField field, DateTime value)
        {
            _metadata[GetMetadataKey(field)] = new[] { DateTimeFunctions.ToEpochSecondsString(value) };
        }

        public void SetInstantFieldValue(IField field, params DateTime[] values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(DateTimeFunctions.ToEpochSecondsString).ToList();
        }

        public void SetInstantFieldValue(IField field, IEnumerable<DateTime> values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(DateTimeFunctions.ToEpochSecondsString).ToList();
        }

        public void AddInstantFieldValue(IField field, DateTime value)
        {
            AddStringFieldValueImpl(field, DateTimeFunctions.ToEpochSecondsString(value));
        }

        public void SetLongFieldValue(IField field, long value)
        {
            _metadata[GetMetadataKey(field)] = new[] { value.ToString(NumberFormatInfo.InvariantInfo) };
        }

        public void SetLongFieldValue(IField field, params long[] values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(value => value.ToString(NumberFormatInfo.InvariantInfo)).ToList();
        }

        public void SetLongFieldValue(IField field, IEnumerable<long> values)
        {
            _metadata[GetMetadataKey(field)] = values.Select(value => value.ToString(NumberFormatInfo.InvariantInfo)).ToList();
        }

        public void AddLongFieldValue(IField field, long value)
        {
            AddStringFieldValueImpl(field, value.ToString(NumberFormatInfo.InvariantInfo));
        }

        public void SetStringFieldValue(IField field, string value)
        {
            _metadata[GetMetadataKey(field)] = new[] { value };
        }

        public void SetStringFieldValue(IField field, params string[] values)
        {
            _metadata[GetMetadataKey(field)] = values.ToList();
        }

        public void SetStringFieldValue(IField field, IEnumerable<string> values)
        {
            _metadata[GetMetadataKey(field)] = values.ToList();
        }

        public void AddStringFieldValue(IField field, string value)
        {
            AddStringFieldValueImpl(field, value);
        }

        public void SetJsonFieldValue(IField field, Action<IJsonBuilder> director)
        {
            _metadata[GetMetadataKey(field)] = new[] { _jsonStringBuilder.Invoke(director) };
        }

        public void SetJsonFieldValue(IField field, IEnumerable<Action<IJsonBuilder>> directors)
        {
            _metadata[GetMetadataKey(field)] = directors.Select(_jsonStringBuilder.Invoke).ToList();
        }

        public void SetFlattenedFieldValue(IField field, Action<ISchemaObjectBuilder> director)
        {
            string nextLevelPrefix = (field == null)
                ? _prefix + "0_"
                : _prefix + field.FieldName + (field.IsMultivalue ? "_0_" : "__");

            director.Invoke(new StringDictionarySchemaObjectBuilderImpl(_metadata, _jsonStringBuilder, nextLevelPrefix));
        }

        public void SetFlattenedFieldValue(IField field, IEnumerable<Action<ISchemaObjectBuilder>> directors)
        {
            string basePrefix = (field == null)
                ? _prefix
                : _prefix + field.FieldName + "_";

            int i = 0;
            foreach (var director in directors)
            {
                string nextLevelPrefix = basePrefix + i + "_";
                director.Invoke(new StringDictionarySchemaObjectBuilderImpl(_metadata, _jsonStringBuilder, nextLevelPrefix));
                i++;
            }
        }

        private string GetMetadataKey(IField field)
        {
            if (_prefix.Length == 0)
            {
                Debug.Assert(field.ParentField == null, "Parent field should be null.");
                return field.FieldName;
            }
            else
            {
                Debug.Assert(field.ParentField != null, "Parent field should not be null.");
                return _prefix + field.FieldName;
            }
        }

        private void AddStringFieldValueImpl(IField field, string newValue)
        {
            string metadataKey = GetMetadataKey(field);
            _metadata.TryGetValue(metadataKey, out IEnumerable<string> currentValues);

            if (currentValues is List<string> currentList)
            {
                currentList.Add(newValue);
            }
            else
            {
                var newList = (currentValues == null)
                    ? new List<string>()
                    : new List<string>(currentValues);

                newList.Add(newValue);

                _metadata[metadataKey] = newList;
            }
        }
    }
}
