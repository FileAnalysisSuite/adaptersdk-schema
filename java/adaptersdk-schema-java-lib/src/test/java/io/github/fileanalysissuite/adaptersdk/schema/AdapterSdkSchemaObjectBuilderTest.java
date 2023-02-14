/*
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
package io.github.fileanalysissuite.adaptersdk.schema;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public final class AdapterSdkSchemaObjectBuilderTest
{
    @Test
    public void testCreateDataSetWithSchemaObjectBuilder()
    {
        System.out.println("testCreateDataSetWithSchemaObjectBuilder...");
        final Map<String, Object> document = new HashMap<String, Object>();
        final AdapterSdkSchemaObjectBuilder documentBuilder = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));

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
                builder.setHandles("handle1", "handle2");
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

        // multi-values Nested object, single-dimension - flattened
        //Setting multiple values for single-dimension multi-valued Nested object
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
        // Setting single value for multi-valued Nested object, multi-dimension - flattened
        documentBuilder.setOcr(
            Stream.of(
                listBuilder -> {
                    listBuilder.set(
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
                listBuilder -> {
                    listBuilder.set(
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

        System.out.println("-------------   Built AdapterSdkSchemaObject ---------------------\n");
        final Map<String, Object> treeMap = new TreeMap<String, Object>(document);
        treeMap.entrySet().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        assertTrue(document.containsKey("ACCOUNTS"));
        assertTrue(document.containsKey("COLUMNS"));
        assertTrue(document.containsKey("METADATA_FILES_0_CONTENT"));
        assertTrue(document.containsKey("METADATA_FILES_1_EXTENSION"));
        assertTrue(document.containsKey("OCR_0_0_CONFIDENCE"));
        assertTrue(document.containsKey("OCR_0_1_VALUE"));
        assertTrue(document.containsKey("OCR_1_0_NAME"));
        assertTrue(document.containsKey("OCR_1_1_VALUE"));
    }

    @Test
    public void testMandatoryFieldNotSet()
    {
        System.out.println("testMandatoryFieldNotSet...");
        final Map<String, Object> document = new HashMap<String, Object>();
        final AdapterSdkSchemaObjectBuilder documentBuilder = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));
        final IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> documentBuilder.setOcr(
                Stream.of(
                    listBuilder -> {
                        listBuilder.set(
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
                    listBuilder -> {
                        listBuilder.set(
                            Stream.of(
                                builder -> {
                                    builder.setName("Reporter");
                                    builder.setType("Name");
                                    builder.setValue("Jane Doe");
                                    builder.setConfidence(41);
                                },
                                builder -> {
                                    builder.setConfidence(44);
                                    // builder.setValue("free form text from a non-templated region"); // mandatory field not set
                                }
                            )
                        );
                    }
                )
            ),
            "Expected setOcr() to throw IllegalArgumentException, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Mandatory field 'AdapterSdkSchema.OCR.VALUE' is not set"));
    }

    @Test
    public void testSingleDimensionMandatoryFieldNotSet()
    {
        System.out.println("testSingleDimensionMandatoryFieldNotSet...");
        final Map<String, Object> document = new HashMap<String, Object>();
        final AdapterSdkSchemaObjectBuilder documentBuilder = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));
        final IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> documentBuilder.setMetadataFiles(Stream.of(
                builder -> {
                    builder.setContent("mdf-content1");
                    // builder.setExtension("abc"); // mandatory field not set
                },
                builder -> {
                    builder.setContent("mdf-content2");
                    builder.setExtension("xyz");
                })
            ),
            "Expected setMetadataFiles() to throw IllegalArgumentException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("Mandatory field 'AdapterSdkSchema.METADATA_FILES.EXTENSION' is not set"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testValidAdapterSdkSchemaObject()
    {
        System.out.println("testValidAdapterSdkSchemaObject...");
        final Map<String, Object> document = new HashMap<String, Object>();
        final AdapterSdkSchemaObjectBuilder documentBuilder = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));
        documentBuilder.setFileName("test.doc");
        documentBuilder.setHash("9876dfg");
        documentBuilder.setMimetype("msword");
        documentBuilder.setTitle("Test File");
        documentBuilder.setType("323");
        documentBuilder.setAddressDisplayBcc("abc", "def");
        documentBuilder.setAddressDisplayTo("toAddress1");
        documentBuilder.clearAddressDisplayBcc();
        documentBuilder.addAddressDisplayTo("toAddress2");
        documentBuilder.validate();
        System.out.println("-------------   Built AdapterSdkSchemaObject ---------------------\n");
        final Map<String, Object> treeMap = new TreeMap<String, Object>(document);
        treeMap.entrySet().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        assertTrue(document.containsKey("FILE_NAME"));
        assertTrue(document.containsKey("TITLE"));
        assertFalse(document.containsKey("ADDRESS_DISPLAY_BCC"));
        assertEquals(2, ((List<String>)document.get("ADDRESS_DISPLAY_TO")).size());
    }

    @Test
    public void testInvalidAdapterSdkSchemaObject()
    {
        System.out.println("testInvalidAdapterSdkSchemaObject...");
        final Map<String, Object> document = new HashMap<String, Object>();
        final AdapterSdkSchemaObjectBuilder documentBuilder = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));
        documentBuilder.setFileName("test.doc");
        documentBuilder.setHash("9876dfg");
        //documentBuilder.setMimetype("msword"); //mandatory field not set
        documentBuilder.setTitle("Test File");
        documentBuilder.setType("323");
        documentBuilder.setOcr(
            Stream.of(
                listBuilder -> {
                    listBuilder.set(
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
                listBuilder -> {
                    listBuilder.set(
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
        final IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> documentBuilder.validate(),
            "Expected validate() to throw IllegalArgumentException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("Mandatory field 'AdapterSdkSchema.MIMETYPE' is not set"));
    }
}
