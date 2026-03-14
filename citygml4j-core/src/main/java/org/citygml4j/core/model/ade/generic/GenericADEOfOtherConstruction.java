/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfOtherConstruction;
import org.w3c.dom.Element;

public class GenericADEOfOtherConstruction extends ADEOfOtherConstruction implements ADEGenericProperty {
    private Element value;

    private GenericADEOfOtherConstruction(Element value) {
        this.value = value;
    }

    public static GenericADEOfOtherConstruction of(Element value) {
        return new GenericADEOfOtherConstruction(value);
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
