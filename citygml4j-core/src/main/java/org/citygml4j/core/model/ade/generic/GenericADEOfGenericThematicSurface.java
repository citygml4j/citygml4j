/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.generics.ADEOfGenericThematicSurface;
import org.w3c.dom.Element;

public class GenericADEOfGenericThematicSurface extends ADEOfGenericThematicSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfGenericThematicSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfGenericThematicSurface of(Element value) {
        return new GenericADEOfGenericThematicSurface(value);
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
