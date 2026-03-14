/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.generics.ADEOfGenericOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEOfGenericOccupiedSpace extends ADEOfGenericOccupiedSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfGenericOccupiedSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfGenericOccupiedSpace of(Element value) {
        return new GenericADEOfGenericOccupiedSpace(value);
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
