/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfAbstractFurniture;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFurniture extends ADEOfAbstractFurniture implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractFurniture of(Element value) {
        return new GenericADEOfAbstractFurniture(value);
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
