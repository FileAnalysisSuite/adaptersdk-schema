# Adapter SDK Schema

The **Adapter SDK Schema** is a representation of the data that an adapter retrieves from a repository.
The schema defines a set of fields that the adapters are allowed to set.

This repository has code that auto generates schema definition libraries in multiple languages based on this [schema descriptor](schemaDefinition.json.yaml).

These libraries provide classes that expose the schema fields to Adapter implementations.

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
