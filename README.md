# Adapter SDK Schema

The **Adapter SDK Schema** is a representation of the data that an adapter retrieves from a repository.
The schema defines a set of fields that the adapters are allowed to set.

This repository has code that auto generates schema definition libraries in multiple languages based on this [schema descriptor](schemaDefinition.json.yaml).

These libraries provide classes that expose the schema fields to Adapter implementations.

The libraries also include builder classes to make it easy to set fields in custom Adapters.
The builder classes have type safe methods to `set` or `clear` fields and a `validate` method to ensure all mandatory fields have been set.

## Usage
Here are some ways to use the `AdapterSdkSchema` to get details about a `Field`


To use the **Java** version of the schema add the following dependencies:

    <dependency>
      <groupId>io.github.fileanalysissuite.adaptersdk.schema</groupId>
      <artifactId>adaptersdk-schema-java-interfaces</artifactId>
    </dependency>
    <dependency>
      <groupId>io.github.fileanalysissuite.adaptersdk.schema</groupId>
      <artifactId>adaptersdk-schema-java-lib</artifactId>
    </dependency>


- Access a field:  

    `AdapterSdkSchema.TITLE;`


- Look up a field by its name:  

    `AdapterSdkSchema.getField("ADDRESS_CC");`


- Check if the field is multivalued:  

    `AdapterSdkSchema.getField("ADDRESS_CC").isMultivalue();`


- Check how the field's value is encoded, which could either by `json` or `flattened`:  

    `AdapterSdkSchema.getField("OCR").getObjectEncoding();`


To use the **.NET** version of the schema add the `MicroFocus.FAS.AdapterSdkSchema.dll` package.

- Access a field:  

    `AdapterSdkSchema.TITLE;`


- Look up a field by its name:  

    `AdapterSdkSchema.GetField("ADDRESS_CC");`


- Check if the field is multivalued:  

    `AdapterSdkSchema.GetField("ADDRESS_CC").IsMultivalue;`


- Check the field's type:  

    `AdapterSdkSchema.GetField("TITLE").FieldType;`

Create a **Java** `AdapterSdkSchemaObject` using the `AdapterSdkSchemaObjectBuilder`

- Create a `AdapterSdkSchemaObjectBuilder` passing in an instance of a `SchemaObjectBuilder`

```
    final Map<String, Object> document = new HashMap<String, Object>();
    final AdapterSdkSchemaObjectBuilder documentBuilder
        = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));
```

- Set field values by calling the appropriate setter methods

```
    documentBuilder.setFileName("test.doc");
    documentBuilder.setMimetype("msword");

    documentBuilder.setAddressDisplayBcc("person1@abc.com", "person2@abc.com");
    documentBuilder.setAddressDisplayTo("johnDoe@abc.com");
```

- Clear a field

```
    documentBuilder.clearAddressDisplayBcc();
```

- Add more values to a field

```
    documentBuilder.addAddressDisplayTo("janeDoe@abc.com");
```

- Check if all mandatory fields have been set and a valid `AdapterSdkSchemaObject` has been created

```
    documentBuilder.validate();
```

Create a **.NET** `AdapterSdkSchemaObject` using the `AdapterSdkSchemaObjectBuilder`

- Create a `AdapterSdkSchemaObjectBuilder` passing in an instance of a `ISchemaObjectBuilder`

```
    var document = new Dictionary<string, object>();
    AdapterSdkSchemaObjectBuilder documentBuilder = new(new DictionarySchemaObjectBuilder(document));
```

- Set field values by calling the appropriate setter methods

```
    documentBuilder.SetFileName("test.doc");
    documentBuilder.SetMimetype("msword");

    documentBuilder.SetAddressDisplayBcc("person1@abc.com", "person2@abc.com");
    documentBuilder.SetAddressDisplayTo("johnDoe@abc.com");
```

- Clear a field

```
    documentBuilder.ClearAddressDisplayBcc();
```

- Add more values to a field

```
    documentBuilder.AddAddressDisplayTo("janeDoe@abc.com");
```

- Add a nested field values

```
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
```

- Set multiple values for single-dimensional multi-valued nested object

```
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
```

- Set values for multi-dimensional multi-valued nested object 

```
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
```

- Check if all mandatory fields have been set and a valid `AdapterSdkSchemaObject` has been created

```
    documentBuilder.Validate();
```

The SchemaObjectBuilder encodes field values as **json** or **flattened**

Here is an example of a **json** encoded field:
```
COLUMNS =
{
   "GRAMMAR_MATCHES":[
      {
         "RULES":[
            "RuleA-1",
            "RuleA-2"
         ],
         "WEIGHT":50
      }
   ],
   "NAME":"ColumnA",
   "REVIEWED_BY":"somebody",
   "REVIEWER_COMMENTS":"LGTM",
   "SELECTED_GRAMMAR_RULE":"GrammarRuleA",
   "STATUS":"REVIEWED",
   "TYPE":"TypeA"
},
{
   "GRAMMAR_MATCHES":[
      {
         "RULES":[
            "RuleB-1",
            "RuleB-2"
         ],
         "WEIGHT":30
      }
   ],
   "NAME":"ColumnB",
   "REVIEWED_BY":"somebody",
   "REVIEWER_COMMENTS":"Needs changes",
   "SELECTED_GRAMMAR_RULE":"GrammarRuleB",
   "STATUS":"REVIEWED",
   "TYPE":"TypeB"
}
```
Here is an example of a single dimensional **flattened** field:
```
METADATA_FILES_0_CONTENT = mdf-content1
METADATA_FILES_0_EXTENSION = abc
METADATA_FILES_1_CONTENT = mdf-content2
METADATA_FILES_1_EXTENSION = xyz
```
Here is an example of a two dimensional **flattened** field:
```
OCR_0_0_CONFIDENCE = 41
OCR_0_0_NAME = Reporter
OCR_0_0_TYPE = Name
OCR_0_0_VALUE = John Doe
OCR_0_1_CONFIDENCE = 42
OCR_0_1_VALUE = free form text from a non-templated region
OCR_1_0_CONFIDENCE = 41
OCR_1_0_NAME = Reporter
OCR_1_0_TYPE = Name
OCR_1_0_VALUE = Jane Doe
OCR_1_1_CONFIDENCE = 44
OCR_1_1_VALUE = free form text from a non-templated region
```
