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
namespace MicroFocus.FAS.AdapterSdkSchema
{
    internal sealed class DictionarySchemaObjectBuilder : ISchemaObjectBuilder
    {
        private readonly Dictionary<string, object> _document;

        public DictionarySchemaObjectBuilder(Dictionary<string, object> document)
        {
            this._document = document;
        }
        public void AddBooleanFieldValue(IField field, bool value)
        {
            object? currentValue = _document.GetValueOrDefault(field.FieldName);
            currentValue ??= new List<bool>();
            ((List<bool>)currentValue).Add(value);
            _document.Add(field.FieldName, currentValue);
        }

        public void AddDoubleFieldValue(IField field, double value)
        {
            object? currentValue = _document.GetValueOrDefault(field.FieldName);
            currentValue ??= new List<double>();
            ((List<double>)currentValue).Add(value);
            _document.Add(field.FieldName, currentValue);
        }

        public void AddInstantFieldValue(IField field, DateTime value)
        {
            object? currentValue = _document.GetValueOrDefault(field.FieldName);
            currentValue ??= new List<DateTime>();
            ((List<DateTime>)currentValue).Add(value);
            _document.Add(field.FieldName, currentValue);
        }

        public void AddIntegerFieldValue(IField field, int value)
        {
            object? currentValue = _document.GetValueOrDefault(field.FieldName);
            currentValue ??= new List<int>();
            ((List<int>)currentValue).Add(value);
            _document.Add(field.FieldName, currentValue);
        }

        public void AddLongFieldValue(IField field, long value)
        {
            object? currentValue = _document.GetValueOrDefault(field.FieldName);
            currentValue ??= new List<long>();
            ((List<long>)currentValue).Add(value);
            _document.Add(field.FieldName, currentValue);
        }

        public void AddStringFieldValue(IField field, string value)
        {
            object? currentValue = _document.GetValueOrDefault(field.FieldName);
            currentValue ??= new List<string>();
            ((List<string>)currentValue).Add(value);
            _document.Add(field.FieldName, currentValue);
        }

        public void ClearField(IField field)
        {
            _document.Remove(field.FieldName);
        }

        public void SetBooleanFieldValue(IField field, bool value)
        {
            _document.Add(field.FieldName, value);
        }

        public void SetBooleanFieldValue(IField field, params bool[] values)
        {
            _document.Add(field.FieldName, values.ToList());
        }

        public void SetBooleanFieldValue(IField field, IEnumerable<bool> values)
        {
            _document.Add(field.FieldName, values);
        }

        public void SetDoubleFieldValue(IField field, double value)
        {
            _document.Add(field.FieldName, value);
        }

        public void SetDoubleFieldValue(IField field, params double[] values)
        {
            _document.Add(field.FieldName, values.ToList());
        }

        public void SetDoubleFieldValue(IField field, IEnumerable<double> values)
        {
            _document.Add(field.FieldName, values);
        }

        public void SetInstantFieldValue(IField field, DateTime value)
        {
            _document.Add(field.FieldName, value);
        }

        public void SetInstantFieldValue(IField field, params DateTime[] values)
        {
            _document.Add(field.FieldName, values.ToList());
        }

        public void SetInstantFieldValue(IField field, IEnumerable<DateTime> values)
        {
            _document.Add(field.FieldName, values);
        }

        public void SetIntegerFieldValue(IField field, int value)
        {
            _document.Add(field.FieldName, value);
        }

        // TODO: This is the only function called when setting a single valued field
        public void SetIntegerFieldValue(IField field, params int[] values)
        {
            _document.Add(field.FieldName, values.ToList());
        }

        public void SetIntegerFieldValue(IField field, IEnumerable<int> values)
        {
            _document.Add(field.FieldName, values);
        }

        public void SetLongFieldValue(IField field, long value)
        {
            _document.Add(field.FieldName, value);
        }

        public void SetLongFieldValue(IField field, params long[] values)
        {
            _document.Add(field.FieldName, values.ToList());
        }

        public void SetLongFieldValue(IField field, IEnumerable<long> values)
        {
            _document.Add(field.FieldName, values);
        }

        public void SetStringFieldValue(IField field, string value)
        {
            _document.Add(field.FieldName, value);
        }

        public void SetStringFieldValue(IField field, params string[] values)
        {
            _document.Add(field.FieldName, values.ToList());
        }

        public void SetStringFieldValue(IField field, IEnumerable<string> values)
        {
            _document.Add(field.FieldName, values);
        }

        public void SetJsonFieldValue(IField field, Action<IJsonBuilder> builder)
        {
            SystemJsonBuilder jsonBuilder = new SystemJsonBuilder();
            builder.Invoke(jsonBuilder);

            _document.Add(field.FieldName, jsonBuilder.Encode());
        }

        public void SetJsonFieldValue(IField field, IEnumerable<Action<IJsonBuilder>> builders)
        {
            _document.Add(
            field.FieldName,
            builders.Select(builder => {
                SystemJsonBuilder jsonBuilder = new SystemJsonBuilder();
                builder.Invoke(jsonBuilder);
                return jsonBuilder.Encode();
            }).ToList());
        }

        public void SetFlattenedFieldValue(IField field, Action<ISchemaObjectBuilder> director)
        {
            string prefix = (field == null ? "" : field.FieldName + "_") + "0_";
            PutFieldValues(prefix, director);
        }

        public void SetFlattenedFieldValue(IField field, IEnumerable<Action<ISchemaObjectBuilder>> directors)
        {
            string basePrefix = field == null ? "" : field.FieldName + "_";
            int i = 0;
            foreach (Action< ISchemaObjectBuilder > director in directors)
            {
                string prefix = basePrefix + i + "_";
                PutFieldValues(prefix, director);
                i++;
            }
        }

        private void PutFieldValues(string prefix, Action<ISchemaObjectBuilder> director)
        {
            var nextLevel = new Dictionary< string, object> ();
            var nextLevelBuilder = new DictionarySchemaObjectBuilder(nextLevel);
            director.Invoke(nextLevelBuilder);
            foreach (var entry in nextLevel)
            {
                _document.Add(prefix + entry.Key, entry.Value);
            }
        }
    }
}
