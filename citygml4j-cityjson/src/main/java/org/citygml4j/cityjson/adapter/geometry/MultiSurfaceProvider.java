/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.cityjson.adapter.geometry;

import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MultiSurfaceProvider {
    private final Supplier<MultiSurfaceProperty> supplier;
    private final Consumer<MultiSurfaceProperty> consumer;

    private MultiSurfaceProvider(Supplier<MultiSurfaceProperty> supplier, Consumer<MultiSurfaceProperty> consumer) {
        this.supplier = supplier;
        this.consumer = consumer;
    }

    public static MultiSurfaceProvider of(Supplier<MultiSurfaceProperty> supplier, Consumer<MultiSurfaceProperty> consumer) {
        return new MultiSurfaceProvider(supplier, consumer);
    }

    public MultiSurfaceProperty get() {
        return supplier.get();
    }

    public void set(MultiSurfaceProperty property) {
        consumer.accept(property);
    }
}
