/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfGroundSurface;
import org.w3c.dom.Element;

public class GenericADEOfGroundSurface extends ADEOfGroundSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfGroundSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfGroundSurface of(Element value) {
        return new GenericADEOfGroundSurface(value);
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
