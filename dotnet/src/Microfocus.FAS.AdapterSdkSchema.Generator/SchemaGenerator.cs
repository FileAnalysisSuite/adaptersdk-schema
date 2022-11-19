/**
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
using Microsoft.CodeAnalysis;
using Microsoft.CodeAnalysis.CSharp;
using Microsoft.CodeAnalysis.Text;
using System.Diagnostics;
using System.Text;

namespace MicroFocus.FAS.AdapterSdkSchema
{
    [Generator]
    public class SchemaGenerator : ISourceGenerator
    {
        public SchemaGenerator()
        {
        }
        public void Initialize(GeneratorInitializationContext context)
        {
        }
        public void Execute(GeneratorExecutionContext context)
        {
            // Define a class
            var schemaSource = SchemaSourceCreator.Create();
            var formattedSchemaSource = CSharpSyntaxTree.ParseText(schemaSource).GetRoot().NormalizeWhitespace().ToFullString();
            Debug.WriteLine("schema source : " + formattedSchemaSource);

            // inject the created source into the compilation
            context.AddSource("AdapterSdkSchemaGenerated.g.cs", SourceText.From(formattedSchemaSource, Encoding.UTF8));
        }
    }
}
