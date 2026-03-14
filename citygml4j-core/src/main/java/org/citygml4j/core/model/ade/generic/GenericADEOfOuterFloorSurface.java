/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfOuterFloorSurface;
import org.w3c.dom.Element;

public class GenericADEOfOuterFloorSurface extends ADEOfOuterFloorSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfOuterFloorSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfOuterFloorSurface of(Element value) {
        return new GenericADEOfOuterFloorSurface(value);
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
