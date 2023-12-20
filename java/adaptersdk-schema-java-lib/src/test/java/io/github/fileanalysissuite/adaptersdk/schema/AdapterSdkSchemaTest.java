/*
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
package io.github.fileanalysissuite.adaptersdk.schema;

import io.github.fileanalysissuite.adaptersdk.schema.model.Field.ObjectEncoding;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public final class AdapterSdkSchemaTest
{
    @Test
    public void testMandatoryField()
    {
        assertTrue(AdapterSdkSchema.getField("FILE_NAME").isMandatory());
    }

    @Test
    public void testIgnoreCaseField()
    {
        assertTrue(AdapterSdkSchema.getField("TITLE").isCaseInsensitive());
    }

    @Test
    public void testTokenizedPathField()
    {
        assertTrue(AdapterSdkSchema.getField("FILEPATH").isTokenizedPath());
    }

    @Test
    public void testFlattenedField()
    {
        assertEquals(ObjectEncoding.FLATTENED, AdapterSdkSchema.getField("METADATA_FILES").getObjectEncoding());
    }

    @Test
    public void testJsonField()
    {
        assertEquals(ObjectEncoding.JSON, AdapterSdkSchema.getField("accounts", true).getObjectEncoding());
    }

    @Test
    public void testObjectField()
    {
        assertEquals("ocr[]", AdapterSdkSchema.getField("OCR").getFieldType());
    }

    @Test
    public void testNestedMandatoryField()
    {
        assertTrue(AdapterSdkSchema.getField("METADATA_FILES.CONTENT").isMandatory());
    }

    @Test
    public void testStringField()
    {
        assertEquals("STRING", AdapterSdkSchema.getField("PARENT_REFERENCE").getFieldType());
    }

    @Test
    public void testMultiStringField()
    {
        assertTrue(AdapterSdkSchema.getField("ADDRESS_CC").isMultivalue());
    }

    @Test
    public void testLongField()
    {
        assertEquals("LONG", AdapterSdkSchema.getField("FILE_SIZE").getFieldType());
    }

    @Test
    public void testObjectParentField()
    {
        assertEquals("METADATA_FILES",
                     AdapterSdkSchema.getField("METADATA_FILES.CONTENT").getParentField().getFieldName());
    }

    @Test
    @SuppressWarnings("ThrowableResultIgnored")
    public void exceptionTesting()
    {
        assertThrows(FieldNotFoundException.class,
                     () -> AdapterSdkSchema.getField("NON_EXISTANT_FIELD"),
                     "Expected FieldNotFoundException");
    }
}
