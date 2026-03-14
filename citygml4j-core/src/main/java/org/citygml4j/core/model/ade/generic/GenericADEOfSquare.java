/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfSquare;
import org.w3c.dom.Element;

public class GenericADEOfSquare extends ADEOfSquare implements ADEGenericProperty {
    private Element value;

    private GenericADEOfSquare(Element value) {
        this.value = value;
    }

    public static GenericADEOfSquare of(Element value) {
        return new GenericADEOfSquare(value);
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
