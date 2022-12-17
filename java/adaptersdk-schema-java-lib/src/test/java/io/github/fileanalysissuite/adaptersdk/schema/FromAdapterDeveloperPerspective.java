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
import java.util.Map;
import java.util.stream.Stream;

// Say a developer is building a SalesForceAdapter
public class FromAdapterDeveloperPerspective
{
    public static void doSomething(final Map<String, Object> document)
    {
        // Error prone to make an un-typed schema object this way, mis-spelled keys, unvalid keys
        //document.put("DATE_ARCHIVED", Instant.now());

        // Instead use typed builders
        // Here is how a Map can be built for an Adapter's DataSet (earlier known as Repository)
        final AdapterSdkSchemaObjectBuilder documentBuilder = new AdapterSdkSchemaObjectBuilder(new MapSchemaObjectBuilder(document));

        documentBuilder.setDateArchived(Instant.now());
        documentBuilder.setAddressBcc("kjhgjkg");

        documentBuilder.setAccounts(Stream.of(
            builder -> {
                builder.setDisplayName("abc");
                builder.setIdentifier("the-id");
            },
            builder -> {
                builder.setDisplayName("abcd");
                builder.setIdentifier("the-id2");
            })
        );
    }
}
