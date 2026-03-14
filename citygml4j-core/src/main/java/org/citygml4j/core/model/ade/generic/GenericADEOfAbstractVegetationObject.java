/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.vegetation.ADEOfAbstractVegetationObject;
import org.w3c.dom.Element;

public class GenericADEOfAbstractVegetationObject extends ADEOfAbstractVegetationObject implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractVegetationObject(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractVegetationObject of(Element value) {
        return new GenericADEOfAbstractVegetationObject(value);
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
