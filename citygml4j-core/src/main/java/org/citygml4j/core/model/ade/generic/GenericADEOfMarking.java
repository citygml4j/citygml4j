/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfMarking;
import org.w3c.dom.Element;

public class GenericADEOfMarking extends ADEOfMarking implements ADEGenericProperty {
    private Element value;

    private GenericADEOfMarking(Element value) {
        this.value = value;
    }

    public static GenericADEOfMarking of(Element value) {
        return new GenericADEOfMarking(value);
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
