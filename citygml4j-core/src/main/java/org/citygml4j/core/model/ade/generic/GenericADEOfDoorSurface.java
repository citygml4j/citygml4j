/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfDoorSurface;
import org.w3c.dom.Element;

public class GenericADEOfDoorSurface extends ADEOfDoorSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfDoorSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfDoorSurface of(Element value) {
        return new GenericADEOfDoorSurface(value);
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
