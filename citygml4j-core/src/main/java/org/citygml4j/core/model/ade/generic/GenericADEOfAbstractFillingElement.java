/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfAbstractFillingElement;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFillingElement extends ADEOfAbstractFillingElement implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractFillingElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractFillingElement of(Element value) {
        return new GenericADEOfAbstractFillingElement(value);
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
