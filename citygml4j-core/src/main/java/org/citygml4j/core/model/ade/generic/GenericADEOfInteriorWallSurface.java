/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfInteriorWallSurface;
import org.w3c.dom.Element;

public class GenericADEOfInteriorWallSurface extends ADEOfInteriorWallSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfInteriorWallSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfInteriorWallSurface of(Element value) {
        return new GenericADEOfInteriorWallSurface(value);
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
