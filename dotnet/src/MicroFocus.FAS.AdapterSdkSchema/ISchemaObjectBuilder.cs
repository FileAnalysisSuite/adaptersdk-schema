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
using System.Collections.Generic;

namespace MicroFocus.FAS.AdapterSdkSchema
{
    public interface ISchemaObjectBuilder
    {
        void ClearField(IField field);

        void SetBooleanFieldValue(IField field, bool value);

        void SetBooleanFieldValue(IField field, params bool[] values);

        void SetBooleanFieldValue(IField field, IEnumerable<bool> values);

        void AddBooleanFieldValue(IField field, bool value);

        void SetDoubleFieldValue(IField field, double value);

        void SetDoubleFieldValue(IField field, params double[] values);

        void SetDoubleFieldValue(IField field, IEnumerable<double> values);

        void AddDoubleFieldValue(IField field, double value);

        void SetIntegerFieldValue(IField field, int value);

        void SetIntegerFieldValue(IField field, params int[] values);

        void SetIntegerFieldValue(IField field, IEnumerable<int> values);

        void AddIntegerFieldValue(IField field, int value);

        void SetInstantFieldValue(IField field, DateTime value);

        void SetInstantFieldValue(IField field, params DateTime[] values);

        void SetInstantFieldValue(IField field, IEnumerable<DateTime> values);

        void AddInstantFieldValue(IField field, DateTime value);

        void SetLongFieldValue(IField field, long value);

        void SetLongFieldValue(IField field, params long[] values);

        void SetLongFieldValue(IField field, IEnumerable<long> values);

        void AddLongFieldValue(IField field, long value);

        void SetStringFieldValue(IField field, string value);

        void SetStringFieldValue(IField field, params string[] values);

        void SetStringFieldValue(IField field, IEnumerable<string> values);

        void AddStringFieldValue(IField field, string value);

        void SetJsonFieldValue(IField field, Action<IJsonBuilder> builder);

        void SetJsonFieldValue(IField field, IEnumerable<Action<IJsonBuilder>> builders);

        void SetFlattenedFieldValue(IField field, Action<ISchemaObjectBuilder> builder);

        void SetFlattenedFieldValue(IField field, IEnumerable<Action<ISchemaObjectBuilder>> builders);
    }
}
