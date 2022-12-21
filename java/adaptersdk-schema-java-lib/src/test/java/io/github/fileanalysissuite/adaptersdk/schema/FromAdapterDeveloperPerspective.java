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
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

// Say a developer is building a SalesForceAdapter
public class FromAdapterDeveloperPerspective
{
    public static void main(final String[] args)
    {
        createDataSetWithTestSchemaObjectBuilder(new HashMap<String, Object>());
    }

    public static void createDataSetWithTestSchemaObjectBuilder(final Map<String, Object> document)
    {
        // Error prone to make an untyped schema object this way, misspelled keys, invalid keys
        //document.put("DATE_ARCHIVED", Instant.now());

        // Instead use typed builders
        // Here is how a Map can be built for an Adapter's DataSet (earlier known as Repository)
        System.out.println("Building TestSchemaObject : " + document);
        final TestSchemaObjectBuilder documentBuilder = new TestSchemaObjectBuilder(new MapSchemaObjectBuilder(document));

        // Datetime
        documentBuilder.setDateArchived(Instant.now());
        // Single-valued string
        documentBuilder.setAddressBcc("jdoe@gmail.com");
        // Multi-valued string
        documentBuilder.setAddressTo("person1@gmail.com", "person2@there.com");

        // Multi-valued Nested object, Json encoded
        documentBuilder.setAccounts(Stream.of(
            builder -> {
                builder.setDisplayName("J Doe");
                builder.setIdentifier("jdoe");
                builder.setHandles("handle1" ,"handle2");
            },
            builder -> {
                builder.setDisplayName("foo");
                builder.setIdentifier("fooId");
                builder.setSender(false);
            })
        );

        // 2 level Nested objects, Json encoded
        documentBuilder.setEntities(Stream.of(
            builder -> {
                builder.setEntityId("USA", "India");
                builder.setEntityCategoryId("geo/country");
                builder.setGrammarId("geo");
                builder.setMatches(Stream.of(
                    mbuilder -> {
                        mbuilder.setContext("someMatchCtx");
                        mbuilder.setValue("USA");
                        mbuilder.setScore(99.9);
                    }
                ));
            },
            builder -> {
                builder.setEntityId("234-45-4566");
                builder.setEntityCategoryId("pii/ssn");
                builder.setGrammarId("pii");
            })
        );

        // multi-values Nested object, flattened
        documentBuilder.setMetadataFiles(Stream.of(
            builder -> {
                builder.setContent("mdf-content1");
                builder.setExtension("xyz");
            },
            builder -> {
                builder.setContent("mdf-content2");
                builder.setExtension("abc");
            })
        );

        // multi-values Nested object, flattened
        documentBuilder.setOcr(Stream.of(
            listBuilder -> { listBuilder.set(
                Stream.of(
                    builder -> {
                        builder.setName("Reporter");
                        builder.setType("Name");
                        builder.setValue("John Doe");
                        builder.setConfidence(41);
                    },
                    builder -> {
                        builder.setConfidence(42);
                        builder.setValue("free form text from a non-templated region");
                    }
                )
            );
            },
            listBuilder -> { listBuilder.set(
                Stream.of(
                    builder -> {
                        builder.setName("Reporter2");
                        builder.setType("Name2");
                        builder.setValue("John Doe2");
                        builder.setConfidence(412);
                    },
                    builder -> {
                        builder.setConfidence(422);
                        builder.setValue("free form text from a non-templated region2");
                    }
                )
            );
            })
        );

        System.out.println("Built TestSchemaObject : " + document);
    }
}
