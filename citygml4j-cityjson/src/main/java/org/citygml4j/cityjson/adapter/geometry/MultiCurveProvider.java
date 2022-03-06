/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MultiCurveProvider {
    private final Supplier<MultiCurveProperty> supplier;
    private final Consumer<MultiCurveProperty> consumer;

    private MultiCurveProvider(Supplier<MultiCurveProperty> supplier, Consumer<MultiCurveProperty> consumer) {
        this.supplier = supplier;
        this.consumer = consumer;
    }

    public static MultiCurveProvider of(Supplier<MultiCurveProperty> supplier, Consumer<MultiCurveProperty> consumer) {
        return new MultiCurveProvider(supplier, consumer);
    }

    public MultiCurveProperty get() {
        return supplier.get();
    }

    public void set(MultiCurveProperty property) {
        consumer.accept(property);
    }
}
