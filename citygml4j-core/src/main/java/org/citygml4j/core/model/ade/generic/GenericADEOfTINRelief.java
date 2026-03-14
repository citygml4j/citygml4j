/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.relief.ADEOfTINRelief;
import org.w3c.dom.Element;

public class GenericADEOfTINRelief extends ADEOfTINRelief implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTINRelief(Element value) {
        this.value = value;
    }

    public static GenericADEOfTINRelief of(Element value) {
        return new GenericADEOfTINRelief(value);
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
