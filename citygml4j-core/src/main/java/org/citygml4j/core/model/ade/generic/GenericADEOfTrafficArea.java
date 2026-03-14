/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfTrafficArea;
import org.w3c.dom.Element;

public class GenericADEOfTrafficArea extends ADEOfTrafficArea implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTrafficArea(Element value) {
        this.value = value;
    }

    public static GenericADEOfTrafficArea of(Element value) {
        return new GenericADEOfTrafficArea(value);
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
