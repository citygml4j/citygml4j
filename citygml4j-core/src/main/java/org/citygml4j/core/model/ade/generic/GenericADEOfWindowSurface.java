/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfWindowSurface;
import org.w3c.dom.Element;

public class GenericADEOfWindowSurface extends ADEOfWindowSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfWindowSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfWindowSurface of(Element value) {
        return new GenericADEOfWindowSurface(value);
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
