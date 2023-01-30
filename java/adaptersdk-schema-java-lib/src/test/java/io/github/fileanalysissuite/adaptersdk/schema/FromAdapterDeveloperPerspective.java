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
import java.util.TreeMap;
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
        // Note: Error prone to make an untyped schema object this way, misspelled keys, invalid keys
        // document.put("DATE_ARCHIVED", Instant.now());

        // Instead use typed builders
        // Here is how a Map can be built for an Adapter's DataSet (earlier known as Repository)
        System.out.println("Building TestSchemaObject : " + document);
        final TestSchemaObjectBuilder documentBuilder = new TestSchemaObjectBuilder(new MapSchemaObjectBuilder(document));

        // Integer
        documentBuilder.setColumnCount(3);
        // Long
        documentBuilder.setRootFileSize(418l);
        // Boolean
        documentBuilder.setHasAttachments(false);
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

        // multi- level Nested objects, Json encoded
        documentBuilder.setColumns(Stream.of(
            builder -> {
                builder.setName("ColumnA");
                builder.setReviewedBy("somebody");
                builder.setReviewerComments("LGTM");
                builder.setSelectedGrammarRule("GrammarRuleA");
                builder.setStatus("REVIEWED");
                builder.setType("TypeA");
                builder.setGrammarMatches(Stream.of(
                    mbuilder -> {
                        mbuilder.setRules("RuleA-1", "RuleA-2");
                        mbuilder.setWeight(50);
                    }
                ));
            },
            builder -> {
                builder.setName("ColumnB");
                builder.setReviewedBy("somebody");
                builder.setReviewerComments("Needs changes");
                builder.setSelectedGrammarRule("GrammarRuleB");
                builder.setStatus("REVIEWED");
                builder.setType("TypeB");
                builder.setGrammarMatches(Stream.of(
                    mbuilder -> {
                        mbuilder.setRules("RuleB-1", "RuleB-2");
                        mbuilder.setWeight(30);
                    }
                ));
            })
        );

        // 2 level Nested objects, Flattened
        documentBuilder.setEntities(Stream.of(
            builder -> {
                builder.setEntityId("USA", "India");
                builder.setEntityCategoryId("geo/country");
                builder.setGrammarId("geo");
                builder.setMatches(Stream.of(
                    listBuilder -> listBuilder.set(
                        Stream.of(
                            mbuilder -> {
                                mbuilder.setContext("someMatchCtx");
                                mbuilder.setValue("USA");
                                mbuilder.setScore(99.9); //Double
                                mbuilder.setEgrammars(
                                    egram -> {
                                        egram.addGcontext("gctx1");
                                        egram.setGvalue("gval1");
                                    }
                                );
                            },
                            mbuilder -> {
                                mbuilder.setContext("someMatchCtx2");
                                mbuilder.setValue("USA2");
                                mbuilder.setScore(33.9); //Double
                                mbuilder.setEgrammars(
                                    egram -> {
                                        egram.addGcontext("gctx2");
                                        egram.setGvalue("gval2");
                                    }
                                );
                            }
                        )
                    )
                ));
            },
            builder -> {
                builder.setEntityId("234-45-4566");
                builder.setEntityCategoryId("pii/ssn");
                builder.setGrammarId("pii");
            },
            builder -> {
                builder.setEntityId("Japan", "China");
                builder.setEntityCategoryId("geo/country");
                builder.setGrammarId("geo");
                builder.setMatches(Stream.of(
                    listBuilder -> listBuilder.set(
                        Stream.of(
                            mbuilder -> {
                                mbuilder.setContext("JapanMatchCtx");
                                mbuilder.setValue("Japan");
                                mbuilder.setScore(70.9); //Double
                                mbuilder.setEgrammars(
                                    egram -> {
                                        egram.addGcontext("gctx22");
                                        egram.setGvalue("gval22");
                                    }
                                );
                            },
                            mbuilder -> {
                                mbuilder.setContext("ChinaMatchCtx2");
                                mbuilder.setValue("China");
                                mbuilder.setScore(55.9); //Double
                                mbuilder.setEgrammars(
                                    egram -> {
                                        egram.addGcontext("gctx32");
                                        egram.setGvalue("gval32");
                                    }
                                );
                            }
                        )
                    )
                ));
            })
        );

        // multi-values Nested object, single-dimension - flattened
        // Expected:
        /*
        ----------------
        Json encoding
        ----------------
        METADATA_FILES =
        [
            {"CONTENT":"Reporter","EXTENSION":"xyz"},
            {"CONTENT":"free form text from a non-templated region","EXTENSION":"abc"}
        ]
        ----------------
        Flattened
        ----------------
        METADATA_FILES_0_CONTENT=
        METADATA_FILES_0_EXTENSION=

        METADATA_FILES_1_CONTENT=
        METADATA_FILES_1_EXTENSION=
         */

        /*
        // Setting a single value for single-dimension multi-valued Nested object -- works
        documentBuilder.setMetadataFiles(
            builder -> {
                builder.setContent("mdf-content1");
                builder.setExtension("abc");
            }
        );
        */

        //Setting multiple values for single-dimension multi-valued Nested object -- works
        documentBuilder.setMetadataFiles(Stream.of(
            builder -> {
                builder.setContent("mdf-content1");
                builder.setExtension("abc");
            },
            builder -> {
                builder.setContent("mdf-content2");
                builder.setExtension("xyz");
            })
        );

        // multi-values Nested object, multi-dimension - flattened
        // Expected:
        /*
        ----------------
        Json encoding
        ----------------
        OCR=
        [
            [
                {"CONFIDENCE":41,"NAME":"Reporter","TYPE":"Name","VALUE":"John Doe"},
                {"CONFIDENCE":42,"VALUE":"free form text from a non-templated region"}
            ]
        ]

        OCR=
        [
            [
                {"CONFIDENCE":41,"NAME":"Reporter","TYPE":"Name","VALUE":"John Doe"},
                {"CONFIDENCE":42,"VALUE":"free form text from a non-templated region"}
            ],
            [
                {"CONFIDENCE":412,"NAME":"Reporter2","TYPE":"Name2","VALUE":"John Doe2"},
                {"CONFIDENCE":422,"VALUE":"free form text from a non-templated region2"}
            ]
        ]
        ----------------
        Flattened
        ----------------
        OCR_0_0_CONFIDENCE=41
        OCR_0_0_NAME=Reporter
        OCR_0_0_TYPE=Name
        OCR_0_0_VALUE=John Doe

        OCR_0_1_CONFIDENCE=42
        OCR_0_1_VALUE=free form text from a non-templated region

        OCR_1_0_CONFIDENCE=412
        OCR_1_0_NAME=Reporter2
        OCR_1_0_TYPE=Name2
        OCR_1_0_VALUE=John Doe2

        OCR_1_1_CONFIDENCE=422
        OCR_1_1_VALUE=free form text from a non-templated region2
        */
        // Setting single value for multi-valued Nested object, multi-dimension - flattened
        documentBuilder.setOcr(
            Stream.of(
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
                        builder.setName("Reporter");
                        builder.setType("Name");
                        builder.setValue("Jane Doe");
                        builder.setConfidence(41);
                    },
                    builder -> {
                        builder.setConfidence(44);
                        builder.setValue("free form text from a non-templated region");
                    }
                )
            );
            }
            )
        );

        // Setting multi-values Nested object, multi-dimension - flattened
        /*
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
        );*/

        // entry with flattened encoding with a nested field with json encoding
        documentBuilder.setTest(Stream.of(
            builder -> {
                builder.setTestId("testid-1");
                builder.setTestMatches(
                    mbuilder -> {
                        mbuilder.setType("sometype");
                        mbuilder.setValue("free form text from a non-templated region2");
                    }
                    );
            },
            builder -> {
                builder.setTestId("testid-2");
                builder.setTestMatches(
                    mbuilder -> {
                        mbuilder.setType("someothertype");
                        mbuilder.setValue("free form text from a non-templated region2");
                    }
                    );
            })
        );

        // multi-values Nested object, multi-dimension - json encoding
        documentBuilder.setTestJson(Stream.of(
            listBuilder -> { listBuilder.set(
                Stream.of(
                    builder -> {
                        builder.setSomeType("first somejson type");
                        builder.setSomeValue("first somejson value");
                    },
                    builder -> {
                        builder.setSomeType("first someotherjson type");
                        builder.setSomeValue("first someotherjson value");
                    }
                )
            );
            },
            listBuilder -> { listBuilder.set(
                Stream.of(
                    builder -> {
                        builder.setSomeType("second somejson type");
                        builder.setSomeValue("second somejson value");
                    },
                    builder -> {
                        builder.setSomeType("second someotherjson type");
                        builder.setSomeValue("second someotherjson value");
                    }
                )
            );
            }
            )
        );

        System.out.println("-------------   Built TestSchemaObject ---------------------\n");
        final Map<String, Object> treeMap = new TreeMap<String, Object>(document);
        treeMap.entrySet().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
    }
}
