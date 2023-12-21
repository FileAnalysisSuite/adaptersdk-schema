/*
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
package io.github.fileanalysissuite.adaptersdk.schema.generator;

import com.google.auto.service.AutoService;
import jakarta.annotation.processing.AbstractProcessor;
import jakarta.annotation.processing.Processor;
import jakarta.annotation.processing.RoundEnvironment;
import jakarta.annotation.processing.SupportedAnnotationTypes;
import java.util.Set;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
@SupportedAnnotationTypes("*")
public final class SchemaGeneratorProcessor extends AbstractProcessor
{
    private boolean isProcessed;

    public SchemaGeneratorProcessor()
    {
        this.isProcessed = false;
    }

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv)
    {
        if (isProcessed) {
            return false;
        } else {
            isProcessed = true;
            return SchemaGenerator.generate(processingEnv.getFiler());
        }
    }
}
