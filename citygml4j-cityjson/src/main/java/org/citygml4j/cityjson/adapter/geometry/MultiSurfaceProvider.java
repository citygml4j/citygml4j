/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
