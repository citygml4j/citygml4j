/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractOccupiedSpace extends ADEOfAbstractOccupiedSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractOccupiedSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractOccupiedSpace of(Element value) {
        return new GenericADEOfAbstractOccupiedSpace(value);
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
