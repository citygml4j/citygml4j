/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
