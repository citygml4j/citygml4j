/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfAbstractConstructionSurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstructionSurface extends ADEOfAbstractConstructionSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractConstructionSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractConstructionSurface of(Element value) {
        return new GenericADEOfAbstractConstructionSurface(value);
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
