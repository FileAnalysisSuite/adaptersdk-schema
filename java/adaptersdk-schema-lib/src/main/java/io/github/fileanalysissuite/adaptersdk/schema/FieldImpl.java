/*
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
package io.github.fileanalysissuite.adaptersdk.schema;

import javax.annotation.Nonnull;
import io.github.fileanalysissuite.adaptersdk.schema.model.Field;

class FieldImpl implements Field
{
    private final String fieldName;
    private final String fieldType;
    private final ObjectEncoding objectEncoding;
    private final boolean multivalue;
    private final boolean mandatory;
    private final boolean caseInsensitive;
    private final boolean tokenizedPath;


    FieldImpl(
        final String fieldName,
        final String fieldType,
        final ObjectEncoding objectEncoding,
        final boolean multivalue,
        final boolean mandatory,
        final boolean caseInsensitive,
        final boolean tokenizedPath
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

    @Nonnull
    @Override
    public String getFieldName()
    {
        return fieldName;
    }

    @Override
    public String getFieldType()
    {
        return fieldType;
    }


    @Override
    public ObjectEncoding getObjectEncoding()
    {
        return objectEncoding;
    }

    @Override
    public Field getParentField()
    {
        return null;
    }

    @Override
    public boolean isMultivalue()
    {
        return multivalue;
    }

    @Override
    public boolean isMandatory()
    {
        return mandatory;
    }

    @Override
    public boolean isCaseInsensitive()
    {
        return caseInsensitive;
    }

    @Override
    public boolean isTokenizedPath()
    {
        return tokenizedPath;
    }

}
