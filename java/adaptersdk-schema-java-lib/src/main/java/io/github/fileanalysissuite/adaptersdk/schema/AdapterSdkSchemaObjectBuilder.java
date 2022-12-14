/*
 * Copyright 2022 EntIT Software LLC, a Micro Focus company.
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

public final class AdapterSdkSchemaObjectBuilder
{
    private final SchemaObjectBuilder schemaObjectBuilder;

    public AdapterSdkSchemaObjectBuilder(final SchemaObjectBuilder schemaObjectBuilder)
    {
        this.schemaObjectBuilder = schemaObjectBuilder;
    }

    public void setAddressBcc(final String value)
    {
        schemaObjectBuilder.setFieldValue(AdapterSdkSchema.ADDRESS_BCC, value);
    }

    public void setAddressBcc(final String... values)
    {
        schemaObjectBuilder.setFieldValue(AdapterSdkSchema.ADDRESS_BCC, values);
    }

    public void setAddressBcc(final List<String> values)
    {
        schemaObjectBuilder.setFieldValue(AdapterSdkSchema.ADDRESS_BCC, values);
    }

    public void addAddressBcc(final String value)
    {
        schemaObjectBuilder.addFieldValue(AdapterSdkSchema.ADDRESS_BCC, value);
    }

    public void clearAddressBcc()
    {
        schemaObjectBuilder.clearField(AdapterSdkSchema.ADDRESS_BCC);
    }

    public void setAddressDisplayFrom(final String value)
    {
        schemaObjectBuilder.setFieldValue(AdapterSdkSchema.ADDRESS_DISPLAY_FROM, value);
    }

    public void clearAddressDisplayFrom()
    {
        schemaObjectBuilder.clearField(AdapterSdkSchema.ADDRESS_DISPLAY_FROM);
    }

    public void setDateArchived(final Instant value)
    {
        schemaObjectBuilder.setFieldValue(AdapterSdkSchema.DATE_ARCHIVED, value);
    }

    public void setAccounts(final Consumer<AccountsObjectBuilder> builder)
    {
        final AccountsObjectBuilder accountsBuilder = new AccountsObjectBuilder();
        builder.accept(accountsBuilder);

        schemaObjectBuilder.setFieldValue(
            AdapterSdkSchema.ACCOUNTS,
            jsonBuilder -> {
                accountsBuilder.build(jsonBuilder);
            });
    }

    public void setAccounts(final Stream<Consumer<AccountsObjectBuilder>> builders)
    {
        schemaObjectBuilder.setJsonFieldValue(
            AdapterSdkSchema.ACCOUNTS,
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
                jsonBuilder.writeFieldName(AdapterSdkSchema.ACCOUNTS.DISPLAY_NAME.getFieldName());
                jsonBuilder.writeString(displayName);
            }
            if (identifier != null) {
                jsonBuilder.writeFieldName(AdapterSdkSchema.ACCOUNTS.IDENTIFIER.getFieldName());
                jsonBuilder.writeString(identifier);
            }
            jsonBuilder.writeEndObject();
        }
    }
}
