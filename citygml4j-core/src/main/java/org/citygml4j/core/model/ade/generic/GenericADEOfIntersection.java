/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfIntersection;
import org.w3c.dom.Element;

public class GenericADEOfIntersection extends ADEOfIntersection implements ADEGenericProperty {
    private Element value;

    private GenericADEOfIntersection(Element value) {
        this.value = value;
    }

    public static GenericADEOfIntersection of(Element value) {
        return new GenericADEOfIntersection(value);
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
