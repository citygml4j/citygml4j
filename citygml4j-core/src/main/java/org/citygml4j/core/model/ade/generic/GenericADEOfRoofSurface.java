/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfRoofSurface;
import org.w3c.dom.Element;

public class GenericADEOfRoofSurface extends ADEOfRoofSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfRoofSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfRoofSurface of(Element value) {
        return new GenericADEOfRoofSurface(value);
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
