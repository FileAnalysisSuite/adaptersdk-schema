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
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

namespace MicroFocus.FAS.AdapterSdkSchema.SchemaObjectBuilders
{
    internal sealed class StringDictionarySchemaObjectBuilderImpl : ISchemaObjectBuilder
    {
        private readonly Dictionary<string, IList<string>> _metadata;
        private readonly IJsonStringBuilder _jsonStringBuilder;
        private readonly string _prefix;

        public StringDictionarySchemaObjectBuilderImpl(
            Dictionary<string, IList<string>> metadata,
            IJsonStringBuilder jsonStringBuilder
        ) : this(metadata, jsonStringBuilder, "")
        {
        }

        private StringDictionarySchemaObjectBuilderImpl(
            Dictionary<string, IList<string>> metadata,
            IJsonStringBuilder jsonStringBuilder,
            string prefix
        )
        {
            _metadata = metadata;
            _jsonStringBuilder = jsonStringBuilder;
            _prefix = prefix;
        }

        public void AddBooleanFieldValue(IField field, bool value)
        {
            AddStringFieldValueImpl(field, value.ToString());
        }

        public void AddDoubleFieldValue(IField field, double value)
        {
            AddStringFieldValueImpl(field, value.ToString());
        }

        public void AddInstantFieldValue(IField field, DateTime value)
        {
            AddStringFieldValueImpl(field, DateTimeFunctions.ToEpochSecondsString(value));
        }

        public void AddIntegerFieldValue(IField field, int value)
        {
            AddStringFieldValueImpl(field, value.ToString());
        }

        public void AddLongFieldValue(IField field, long value)
        {
            AddStringFieldValueImpl(field, value.ToString());
        }

        public void AddStringFieldValue(IField field, string value)
        {
            AddStringFieldValueImpl(field, value);
        }

        public void ClearField(IField field)
        {
            string metadataKey = GetMetadataKey(field);

            if (field.ObjectEncoding == ObjectEncoding.Flattened)
            {
                List<string> keysToRemove = _metadata.Keys.Where(key => key.StartsWith(metadataKey + "_")).ToList();
                keysToRemove.ForEach(key => _metadata.Remove(key));
            }
            else
            {
                _metadata.Remove(metadataKey);
            }
        }

        public void SetBooleanFieldValue(IField field, bool value)
        {
            _metadata.Add(GetMetadataKey(field), new[] { value.ToString() });
        }

        public void SetBooleanFieldValue(IField field, params bool[] values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetBooleanFieldValue(IField field, IEnumerable<bool> values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetDoubleFieldValue(IField field, double value)
        {
            _metadata.Add(GetMetadataKey(field), new[] { value.ToString() });
        }

        public void SetDoubleFieldValue(IField field, params double[] values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetDoubleFieldValue(IField field, IEnumerable<double> values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetInstantFieldValue(IField field, DateTime value)
        {
            _metadata.Add(GetMetadataKey(field), new[] { DateTimeFunctions.ToEpochSecondsString(value) });
        }

        public void SetInstantFieldValue(IField field, params DateTime[] values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => DateTimeFunctions.ToEpochSecondsString(value)).ToList());
        }

        public void SetInstantFieldValue(IField field, IEnumerable<DateTime> values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => DateTimeFunctions.ToEpochSecondsString(value)).ToList());
        }

        public void SetIntegerFieldValue(IField field, int value)
        {
            _metadata.Add(GetMetadataKey(field), new[] { value.ToString() });
        }

        public void SetIntegerFieldValue(IField field, params int[] values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetIntegerFieldValue(IField field, IEnumerable<int> values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetLongFieldValue(IField field, long value)
        {
            _metadata.Add(GetMetadataKey(field), new[] { value.ToString() });
        }

        public void SetLongFieldValue(IField field, params long[] values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetLongFieldValue(IField field, IEnumerable<long> values)
        {
            _metadata.Add(GetMetadataKey(field), values.Select(value => value.ToString()).ToList());
        }

        public void SetStringFieldValue(IField field, string value)
        {
            _metadata.Add(GetMetadataKey(field), new[] { value });
        }

        public void SetStringFieldValue(IField field, params string[] values)
        {
            _metadata.Add(GetMetadataKey(field), values.ToList());
        }

        public void SetStringFieldValue(IField field, IEnumerable<string> values)
        {
            _metadata.Add(GetMetadataKey(field), values.ToList());
        }

        public void SetJsonFieldValue(IField field, Action<IJsonBuilder> director)
        {
            _metadata.Add(GetMetadataKey(field), new []{ _jsonStringBuilder.BuildJsonString(director) });
        }

        public void SetJsonFieldValue(IField field, IEnumerable<Action<IJsonBuilder>> directors)
        {
            _metadata.Add(
                GetMetadataKey(field),
                directors.Select(builder => _jsonStringBuilder.BuildJsonString(builder)).ToList());
        }

        public void SetFlattenedFieldValue(IField field, Action<ISchemaObjectBuilder> director)
        {
            string nextLevelPrefix = (field == null)
                ? _prefix + "0_"
                : _prefix + field.FieldName + "_0_";

            director.Invoke(new StringDictionarySchemaObjectBuilderImpl(_metadata, _jsonStringBuilder, nextLevelPrefix));
        }

        public void SetFlattenedFieldValue(IField field, IEnumerable<Action<ISchemaObjectBuilder>> directors)
        {
            string basePrefix = (field == null)
                ? _prefix
                : _prefix + field.FieldName + "_";
            int i = 0;
            foreach (Action< ISchemaObjectBuilder > director in directors)
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
            IList<string> currentList = _metadata[metadataKey];

            if (currentList is List<string>)
            {
                currentList.Add(newValue);
            }
            else
            {
                IList<string> newList = (currentList == null)
                    ? new List<string>()
                    : new List<string>(currentList);

                newList.Add(newValue);

                _metadata[metadataKey] = newList;
            }
        }

    }
}
