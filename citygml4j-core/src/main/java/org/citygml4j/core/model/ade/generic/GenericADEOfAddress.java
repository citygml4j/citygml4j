/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAddress;
import org.w3c.dom.Element;

public class GenericADEOfAddress extends ADEOfAddress implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAddress(Element value) {
        this.value = value;
    }

    public static GenericADEOfAddress of(Element value) {
        return new GenericADEOfAddress(value);
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
