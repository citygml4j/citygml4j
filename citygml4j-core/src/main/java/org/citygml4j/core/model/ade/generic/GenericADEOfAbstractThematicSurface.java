/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractThematicSurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractThematicSurface extends ADEOfAbstractThematicSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractThematicSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractThematicSurface of(Element value) {
        return new GenericADEOfAbstractThematicSurface(value);
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
