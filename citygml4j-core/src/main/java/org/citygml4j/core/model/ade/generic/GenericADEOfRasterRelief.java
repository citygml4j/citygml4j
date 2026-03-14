/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.relief.ADEOfRasterRelief;
import org.w3c.dom.Element;

public class GenericADEOfRasterRelief extends ADEOfRasterRelief implements ADEGenericProperty {
    private Element value;

    private GenericADEOfRasterRelief(Element value) {
        this.value = value;
    }

    public static GenericADEOfRasterRelief of(Element value) {
        return new GenericADEOfRasterRelief(value);
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
