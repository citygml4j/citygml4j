/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;

public class DoubleAttribute extends AbstractGenericAttribute<Double> {

    public DoubleAttribute() {
    }

    public DoubleAttribute(String name, Double value) {
        super(name, value);
    }
}
