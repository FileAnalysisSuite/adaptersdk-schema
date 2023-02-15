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

- Create an instance of the `AdapterSdkSchemaObjectBuilder` passing in an instance of a `SchemaObjectBuilder`

```
    final Map<String, Object> document = new HashMap<String, Object>();
    final AdapterSdkSchemaObjectBuilder documentBuilder = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));
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

- Create an instance of the `AdapterSdkSchemaObjectBuilder` passing in an instance of a `ISchemaObjectBuilder`

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

- Check if all mandatory fields have been set and a valid `AdapterSdkSchemaObject` has been created

```
    documentBuilder.Validate();
```
