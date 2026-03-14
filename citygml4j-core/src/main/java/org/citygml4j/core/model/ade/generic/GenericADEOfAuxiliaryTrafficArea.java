/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfAuxiliaryTrafficArea;
import org.w3c.dom.Element;

public class GenericADEOfAuxiliaryTrafficArea extends ADEOfAuxiliaryTrafficArea implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAuxiliaryTrafficArea(Element value) {
        this.value = value;
    }

    public static GenericADEOfAuxiliaryTrafficArea of(Element value) {
        return new GenericADEOfAuxiliaryTrafficArea(value);
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
