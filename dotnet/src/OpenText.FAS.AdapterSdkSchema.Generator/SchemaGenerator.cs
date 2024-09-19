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
using Microsoft.CodeAnalysis;
using Microsoft.CodeAnalysis.CSharp;
using Microsoft.CodeAnalysis.Text;
using System.Diagnostics;
using System.Text;

namespace OpenText.FAS.AdapterSdkSchema
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
            var schemaSource = SchemaSourceCreator.Create();

            var formattedSchemaSource = CSharpSyntaxTree
                .ParseText(schemaSource)
                .GetRoot()
                .NormalizeWhitespace()
                .ToFullString();

            Debug.WriteLine("schema source : " + formattedSchemaSource);

            // Inject the created source into the compilation
            context.AddSource(
                "AdapterSdkSchemaGenerated.g.cs",
                SourceText.From(formattedSchemaSource, Encoding.UTF8));

            var schemaObjectBuilderSource = SchemaObjectBuilderSourceCreator.Create();

            var formattedSchemaObjectBuilderSource = CSharpSyntaxTree
                .ParseText(schemaObjectBuilderSource)
                .GetRoot()
                .NormalizeWhitespace()
                .ToFullString();

            Debug.WriteLine("schema object builder source : " + formattedSchemaObjectBuilderSource);

            // Inject the created object builder source into the compilation
            context.AddSource(
                "AdapterSdkSchemaObjectBuilderGenerated.g.cs",
                SourceText.From(formattedSchemaObjectBuilderSource, Encoding.UTF8));
        }
    }
}
