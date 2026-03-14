/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfAbstractFillingSurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFillingSurface extends ADEOfAbstractFillingSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractFillingSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractFillingSurface of(Element value) {
        return new GenericADEOfAbstractFillingSurface(value);
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
