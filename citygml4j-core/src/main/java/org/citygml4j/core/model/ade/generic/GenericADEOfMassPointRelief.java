/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.relief.ADEOfMassPointRelief;
import org.w3c.dom.Element;

public class GenericADEOfMassPointRelief extends ADEOfMassPointRelief implements ADEGenericProperty {
    private Element value;

    private GenericADEOfMassPointRelief(Element value) {
        this.value = value;
    }

    public static GenericADEOfMassPointRelief of(Element value) {
        return new GenericADEOfMassPointRelief(value);
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
