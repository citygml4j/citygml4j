/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractSpaceBoundary;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSpaceBoundary extends ADEOfAbstractSpaceBoundary implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractSpaceBoundary(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractSpaceBoundary of(Element value) {
        return new GenericADEOfAbstractSpaceBoundary(value);
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
