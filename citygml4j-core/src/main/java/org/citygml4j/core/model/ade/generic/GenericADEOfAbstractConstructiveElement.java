/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfAbstractConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstructiveElement extends ADEOfAbstractConstructiveElement implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractConstructiveElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractConstructiveElement of(Element value) {
        return new GenericADEOfAbstractConstructiveElement(value);
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
