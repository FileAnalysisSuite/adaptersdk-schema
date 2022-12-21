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

import java.time.Instant;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.github.fileanalysissuite.adaptersdk.schema.builders.JsonBuilder;
import io.github.fileanalysissuite.adaptersdk.schema.builders.SchemaObjectBuilder;

public final class SampleSchemaObjectBuilder
{
    private final SchemaObjectBuilder schemaObjectBuilder;

    public SampleSchemaObjectBuilder(final SchemaObjectBuilder schemaObjectBuilder)
    {
        this.schemaObjectBuilder = schemaObjectBuilder;
    }

    public void setAddressBcc(final String value)
    {
        schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_BCC, value);
    }

    public void setAddressBcc(final String... values)
    {
        schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_BCC, values);
    }

    public void setAddressBcc(final List<String> values)
    {
        schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_BCC, values);
    }

    public void addAddressBcc(final String value)
    {
        schemaObjectBuilder.addStringFieldValue(TestSchema.ADDRESS_BCC, value);
    }

    public void clearAddressBcc()
    {
        schemaObjectBuilder.clearField(TestSchema.ADDRESS_BCC);
    }

    public void setAddressDisplayFrom(final String value)
    {
        schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_FROM, value);
    }

    public void clearAddressDisplayFrom()
    {
        schemaObjectBuilder.clearField(TestSchema.ADDRESS_DISPLAY_FROM);
    }

    public void setDateArchived(final Instant value)
    {
        schemaObjectBuilder.setInstantFieldValue(TestSchema.DATE_ARCHIVED, value);
    }

    public void setAccounts(final Consumer<AccountsObjectBuilder> builder)
    {
        final AccountsObjectBuilder accountsBuilder = new AccountsObjectBuilder();
        builder.accept(accountsBuilder);

        schemaObjectBuilder.setJsonFieldValue(
            TestSchema.ACCOUNTS,
            jsonBuilder -> {
                accountsBuilder.build(jsonBuilder);
            });
    }

    public void setAccounts(final Stream<Consumer<AccountsObjectBuilder>> builders)
    {
        schemaObjectBuilder.setJsonFieldValue(
            TestSchema.ACCOUNTS,
            builders.<Consumer<JsonBuilder>>map(builder -> {
                final AccountsObjectBuilder accountsBuilder = new AccountsObjectBuilder();
                builder.accept(accountsBuilder);
                return jsonBuilder -> {
                    accountsBuilder.build(jsonBuilder);
                };
            }));
    }

    public void setAccounts(final List<Consumer<AccountsObjectBuilder>> builders)
    {
        setAccounts(builders.stream());
    }

    public static final class AccountsObjectBuilder
    {
        private String displayName;
        private String identifier;

        private AccountsObjectBuilder()
        {
        }

        public void setDisplayName(final String value)
        {
            this.displayName = value;
        }

        public void setIdentifier(final String value)
        {
            this.identifier = value;
        }

        private void build(final JsonBuilder jsonBuilder)
        {
            jsonBuilder.writeStartObject();
            if (displayName != null) {
                jsonBuilder.writeFieldName(TestSchema.ACCOUNTS.DISPLAY_NAME.getFieldName());
                jsonBuilder.writeString(displayName);
            }
            if (identifier != null) {
                jsonBuilder.writeFieldName(TestSchema.ACCOUNTS.IDENTIFIER.getFieldName());
                jsonBuilder.writeString(identifier);
            }
            jsonBuilder.writeEndObject();
        }
    }
}
