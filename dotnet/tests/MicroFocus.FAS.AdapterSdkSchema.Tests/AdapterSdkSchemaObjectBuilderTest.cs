/**
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
using System.Collections;
using MicroFocus.FAS.AdapterSdkSchema.SchemaObjectBuilders;
using MicroFocus.FAS.AdapterSdkSchema.JsonBuilders.System;
using Xunit;

namespace MicroFocus.FAS.AdapterSdkSchema.Tests
{
    public class AdapterSdkSchemaObjectBuilderTest
    {
        [Fact]
        public void TestCreateDataSetWithSchemaObjectBuilder()
        {
            Console.WriteLine("TestCreateDataSetWithSchemaObjectBuilder...");
            var document = new Dictionary<string, IEnumerable<string>>();
            AdapterSdkSchemaObjectBuilder documentBuilder = new(
                StringDictionarySchemaObjectBuilder.Create(document, SystemJsonStringBuilder.BuildJsonString));

            // Integer
            documentBuilder.SetColumnCount(3);
            // Long
            documentBuilder.SetRootFileSize(418);
            // Boolean
            documentBuilder.SetHasAttachments(false);
            // Datetime
            documentBuilder.SetDateArchived(DateTime.Now);
            // Single-valued string
            documentBuilder.SetAddressBcc("jdoe@gmail.com");
            // Multi-valued string
            documentBuilder.SetAddressTo("person1@gmail.com", "person2@there.com");

            // Multi-valued Nested object, Json encoded
            documentBuilder.SetAccounts(
                new List<Action<AdapterSdkSchemaObjectBuilder.AccountsObjectBuilder>> {
                    builder=> {
                        builder.SetDisplayName("J Doe");
                        builder.SetIdentifier("jdoe");
                        builder.SetHandles("handle1", "handle2");
                    },
                    builder=> {
                        builder.SetDisplayName("foo");
                        builder.SetIdentifier("fooId");
                        builder.SetSender(false);
                    }
                }
            );

            // multi- level Nested objects, Json encoded
            documentBuilder.SetColumns(
                new List<Action<AdapterSdkSchemaObjectBuilder.ColumnsObjectBuilder>>{
                    builder => {
                        builder.SetName("ColumnA");
                        builder.SetReviewedBy("somebody");
                        builder.SetReviewerComments("LGTM");
                        builder.SetSelectedGrammarRule("GrammarRuleA");
                        builder.SetStatus("REVIEWED");
                        builder.SetType("TypeA");
                        builder.SetGrammarMatches(
                            new List<Action<AdapterSdkSchemaObjectBuilder.ColumnsObjectBuilder.GrammarMatchesObjectBuilder>> {
                                mbuilder => {
                                    mbuilder.SetRules("RuleA-1", "RuleA-2");
                                    mbuilder.SetWeight(50);
                                }
                            }
                        );
                    },
                    builder => {
                        builder.SetName("ColumnB");
                        builder.SetReviewedBy("somebody");
                        builder.SetReviewerComments("Needs changes");
                        builder.SetSelectedGrammarRule("GrammarRuleB");
                        builder.SetStatus("REVIEWED");
                        builder.SetType("TypeB");
                        builder.SetGrammarMatches(
                            new List<Action<AdapterSdkSchemaObjectBuilder.ColumnsObjectBuilder.GrammarMatchesObjectBuilder>> {
                                mbuilder => {
                                    mbuilder.SetRules("RuleB-1", "RuleB-2");
                                    mbuilder.SetWeight(30);
                                }
                            }
                        );
                    }
                }
            );

            // multi-values Nested object, single-dimension - flattened
            //Setting multiple values for single-dimension multi-valued Nested object
            documentBuilder.SetMetadataFiles(
                new List<Action<AdapterSdkSchemaObjectBuilder.MetadataFilesObjectBuilder>> {
                    builder => {
                        builder.SetContent("mdf-content1");
                        builder.SetExtension("abc");
                    },
                    builder => {
                        builder.SetContent("mdf-content2");
                        builder.SetExtension("xyz");
                    }
                }
            );

            // multi-values Nested object, multi-dimension - flattened
            // Setting single value for multi-valued Nested object, multi-dimension - flattened
            documentBuilder.SetOcr(
                new List<Action<AdapterSdkSchemaObjectBuilder.OcrListObjectBuilder>> {
                    listBuilder => {
                        listBuilder.Set(
                            new List<Action<AdapterSdkSchemaObjectBuilder.OcrObjectBuilder>> {
                                builder => {
                                    builder.SetName("Reporter");
                                    builder.SetType("Name");
                                    builder.SetValue("John Doe");
                                    builder.SetConfidence(41);
                                },
                                builder => {
                                    builder.SetConfidence(42);
                                    builder.SetValue("free form text from a non-templated region");
                                }
                            }
                        );
                    },
                    listBuilder => {
                        listBuilder.Set(
                            new List<Action<AdapterSdkSchemaObjectBuilder.OcrObjectBuilder>> {
                                builder => {
                                    builder.SetName("Reporter");
                                    builder.SetType("Name");
                                    builder.SetValue("Jane Doe");
                                    builder.SetConfidence(41);
                                },
                                builder => {
                                    builder.SetConfidence(44);
                                    builder.SetValue("free form text from a non-templated region");
                                }
                            }
                        );
                    }
                }
            );

            PrintDocument(document);

            Assert.True(document.ContainsKey("ACCOUNTS"));
            Assert.True(document.ContainsKey("COLUMNS"));
            Assert.True(document.ContainsKey("METADATA_FILES_0_CONTENT"));
            Assert.True(document.ContainsKey("METADATA_FILES_1_EXTENSION"));
            Assert.True(document.ContainsKey("OCR_0_0_CONFIDENCE"));
            Assert.True(document.ContainsKey("OCR_0_1_VALUE"));
            Assert.True(document.ContainsKey("OCR_1_0_NAME"));
            Assert.True(document.ContainsKey("OCR_1_1_VALUE"));
        }

        [Fact]
        public void TestCreateDataSetWithSchemaObjectBuilderArrayVersion()
        {
            Console.WriteLine("TestCreateDataSetWithSchemaObjectBuilderArrayVersion...");
            var document = new Dictionary<string, IEnumerable<string>>();
            AdapterSdkSchemaObjectBuilder documentBuilder = new(
                StringDictionarySchemaObjectBuilder.Create(document, SystemJsonStringBuilder.BuildJsonString));

            // Integer
            documentBuilder.SetColumnCount(3);
            // Long
            documentBuilder.SetRootFileSize(418);
            // Boolean
            documentBuilder.SetHasAttachments(false);
            // Datetime
            documentBuilder.SetDateArchived(DateTime.Now);
            // Single-valued string
            documentBuilder.SetAddressBcc("jdoe@gmail.com");
            // Multi-valued string
            documentBuilder.SetAddressTo("person1@gmail.com", "person2@there.com");

            // Multi-valued Nested object, Json encoded
            documentBuilder.SetAccounts(
                builder => {
                    builder.SetDisplayName("J Doe");
                    builder.SetIdentifier("jdoe");
                    builder.SetHandles("handle1", "handle2");
                },
                builder => {
                    builder.SetDisplayName("foo");
                    builder.SetIdentifier("fooId");
                    builder.SetSender(false);
                }
            );

            // multi- level Nested objects, Json encoded
            documentBuilder.SetColumns(
                builder => {
                    builder.SetName("ColumnA");
                    builder.SetReviewedBy("somebody");
                    builder.SetReviewerComments("LGTM");
                    builder.SetSelectedGrammarRule("GrammarRuleA");
                    builder.SetStatus("REVIEWED");
                    builder.SetType("TypeA");
                    builder.SetGrammarMatches(
                        mbuilder => {
                            mbuilder.SetRules("RuleA-1", "RuleA-2");
                            mbuilder.SetWeight(50);
                        }
                    );
                },
                    builder => {
                        builder.SetName("ColumnB");
                        builder.SetReviewedBy("somebody");
                        builder.SetReviewerComments("Needs changes");
                        builder.SetSelectedGrammarRule("GrammarRuleB");
                        builder.SetStatus("REVIEWED");
                        builder.SetType("TypeB");
                        builder.SetGrammarMatches(
                            mbuilder => {
                                mbuilder.SetRules("RuleB-1", "RuleB-2");
                                mbuilder.SetWeight(30);
                            }
                        );
                    }
            );

            // multi-values Nested object, single-dimension - flattened
            //Setting multiple values for single-dimension multi-valued Nested object
            documentBuilder.SetMetadataFiles(
                builder => {
                    builder.SetContent("mdf-content1");
                    builder.SetExtension("abc");
                },
                builder => {
                    builder.SetContent("mdf-content2");
                    builder.SetExtension("xyz");
                }
            );

            // multi-values Nested object, multi-dimension - flattened
            // Setting single value for multi-valued Nested object, multi-dimension - flattened
            documentBuilder.SetOcr(
                listBuilder => {
                    listBuilder.Set(
                        builder => {
                            builder.SetName("Reporter");
                            builder.SetType("Name");
                            builder.SetValue("John Doe");
                            builder.SetConfidence(41);
                        },
                        builder => {
                            builder.SetConfidence(42);
                            builder.SetValue("free form text from a non-templated region");
                        }
                    );
                },
                listBuilder => {
                    listBuilder.Set(
                        builder => {
                            builder.SetName("Reporter");
                            builder.SetType("Name");
                            builder.SetValue("Jane Doe");
                            builder.SetConfidence(41);
                        },
                        builder => {
                            builder.SetConfidence(44);
                            builder.SetValue("free form text from a non-templated region");
                        }
                    );
                }
            );

            PrintDocument(document);

            Assert.True(document.ContainsKey("ACCOUNTS"));
            Assert.True(document.ContainsKey("COLUMNS"));
            Assert.True(document.ContainsKey("METADATA_FILES_0_CONTENT"));
            Assert.True(document.ContainsKey("METADATA_FILES_1_EXTENSION"));
            Assert.True(document.ContainsKey("OCR_0_0_CONFIDENCE"));
            Assert.True(document.ContainsKey("OCR_0_1_VALUE"));
            Assert.True(document.ContainsKey("OCR_1_0_NAME"));
            Assert.True(document.ContainsKey("OCR_1_1_VALUE"));
        }

        [Fact]
        public void TestInvalidAdapterSdkSchemaObject()
        {
            Console.WriteLine("TestInvalidAdapterSdkSchemaObject...");
            var document = new Dictionary<string, IEnumerable<string>>();
            AdapterSdkSchemaObjectBuilder documentBuilder = new(
                StringDictionarySchemaObjectBuilder.Create(document, SystemJsonStringBuilder.BuildJsonString));

            documentBuilder.SetFileName("test.doc");
            documentBuilder.SetHash("9876dfg");
            //documentBuilder.SetMimetype("msword"); //mandatory field not set
            documentBuilder.SetTitle("Test File");
            documentBuilder.SetOcr(
                new List<Action<AdapterSdkSchemaObjectBuilder.OcrListObjectBuilder>> {
                    listBuilder => {
                        listBuilder.Set(
                            new List<Action<AdapterSdkSchemaObjectBuilder.OcrObjectBuilder>> {
                                builder => {
                                    builder.SetName("Reporter");
                                    builder.SetType("Name");
                                    builder.SetValue("John Doe");
                                    builder.SetConfidence(41);
                                },
                                builder => {
                                    builder.SetConfidence(42);
                                    builder.SetValue("free form text from a non-templated region");
                                }
                            }
                        );
                    },
                    listBuilder => {
                        listBuilder.Set(
                            new List<Action<AdapterSdkSchemaObjectBuilder.OcrObjectBuilder>> {
                                builder => {
                                    builder.SetName("Reporter");
                                    builder.SetType("Name");
                                    builder.SetValue("Jane Doe");
                                    builder.SetConfidence(41);
                                },
                                builder => {
                                    builder.SetConfidence(44);
                                    builder.SetValue("free form text from a non-templated region");
                                }
                            }
                        );
                    }
                }
            );
            var thrown = Assert.Throws<ArgumentException>(() => documentBuilder.Validate());
            Assert.Contains("Mandatory field 'AdapterSdkSchema.MIMETYPE' is not set", thrown.Message);
        }

        [Fact]
        public void TestMandatoryFieldNotSet()
        {
            Console.WriteLine("TestMandatoryFieldNotSet...");
            var document = new Dictionary<string, IEnumerable<string>>();
            AdapterSdkSchemaObjectBuilder documentBuilder = new(
                StringDictionarySchemaObjectBuilder.Create(document, SystemJsonStringBuilder.BuildJsonString));

            var thrown = Assert.Throws<ArgumentException>(
                () => documentBuilder.SetOcr(
                    new List<Action<AdapterSdkSchemaObjectBuilder.OcrListObjectBuilder>> {
                        listBuilder => {
                            listBuilder.Set(
                                new List<Action<AdapterSdkSchemaObjectBuilder.OcrObjectBuilder>> {
                                    builder => {
                                        builder.SetName("Reporter");
                                        builder.SetType("Name");
                                        builder.SetValue("John Doe");
                                        builder.SetConfidence(41);
                                    },
                                    builder => {
                                        builder.SetConfidence(42);
                                        builder.SetValue("free form text from a non-templated region");
                                    }
                                }
                            );
                        },
                        listBuilder => {
                            listBuilder.Set(
                                new List<Action<AdapterSdkSchemaObjectBuilder.OcrObjectBuilder>> {
                                    builder => {
                                        builder.SetName("Reporter");
                                        builder.SetType("Name");
                                        builder.SetValue("Jane Doe");
                                        builder.SetConfidence(41);
                                    },
                                    builder => {
                                        builder.SetConfidence(44);
                                        // builder.SetValue("free form text from a non-templated region"); // mandatory field not set
                                    }
                                }
                            );
                        }
                    }
                )
            );
            Assert.Contains("Mandatory field 'AdapterSdkSchema.OCR.VALUE' is not set", thrown.Message);
        }

        [Fact]
        public void TestSingleDimensionMandatoryFieldNotSet()
        {
            Console.WriteLine("TestSingleDimensionMandatoryFieldNotSet...");
            var document = new Dictionary<string, IEnumerable<string>>();
            AdapterSdkSchemaObjectBuilder documentBuilder = new(
                StringDictionarySchemaObjectBuilder.Create(document, SystemJsonStringBuilder.BuildJsonString));

            var thrown = Assert.Throws<ArgumentException>(
                () => documentBuilder.SetMetadataFiles(
                    new List<Action<AdapterSdkSchemaObjectBuilder.MetadataFilesObjectBuilder>> {
                        builder => {
                            builder.SetContent("mdf-content1");
                            // builder.SetExtension("abc"); // mandatory field not set
                        },
                        builder => {
                            builder.SetContent("mdf-content2");
                            builder.SetExtension("xyz");
                        }
                    }
                )
            );
            Assert.Contains("Mandatory field 'AdapterSdkSchema.METADATA_FILES.EXTENSION' is not set", thrown.Message);
        }

        [Fact]
        public void TestValidAdapterSdkSchemaObject()
        {
            Console.WriteLine("TestValidAdapterSdkSchemaObject...");
            var document = new Dictionary<string, IEnumerable<string>>();
            AdapterSdkSchemaObjectBuilder documentBuilder = new(
                StringDictionarySchemaObjectBuilder.Create(document, SystemJsonStringBuilder.BuildJsonString));

            documentBuilder.SetFileName("test.doc");
            documentBuilder.SetHash("9876dfg");
            documentBuilder.SetMimetype("msword");
            documentBuilder.SetTitle("Test File");
            documentBuilder.SetAddressDisplayBcc("jdoe@abc.com", "janedoe@abc.com");
            documentBuilder.SetAddressDisplayTo("toAddress1");
            documentBuilder.ClearAddressDisplayBcc();
            documentBuilder.AddAddressDisplayTo("toAddress2");
            documentBuilder.Validate();
            PrintDocument(document);
            Assert.True(document.ContainsKey("FILE_NAME"));
            Assert.True(document.ContainsKey("TITLE"));
            Assert.False(document.ContainsKey("ADDRESS_DISPLAY_BCC"));
            Assert.Equal(2, ((IList)document["ADDRESS_DISPLAY_TO"]).Count);
        }

        private static void PrintDocument(Dictionary<string, IEnumerable<string>> document)
        {
            Console.WriteLine("-------------   Built AdapterSdkSchemaObject ---------------------\n");
            var treeMap = new SortedDictionary<string, IEnumerable<string>>(document);
            foreach (var e in treeMap)
            {
                Console.WriteLine(e.Key + " = " + PrintValue(e.Value));
            }
        }

        private static string? PrintValue(object? value)
        {
            if (value is IList values)
            {
                string retVal = "";
                foreach(var val in values)
                {
                    retVal += val.ToString() + ", ";
                }
                return retVal.EndsWith(", ") ? retVal[..^2] : retVal;
            }
            else
            {
                return value?.ToString();
            }
        }
    }
}
