/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfHole;
import org.w3c.dom.Element;

public class GenericADEOfHole extends ADEOfHole implements ADEGenericProperty {
    private Element value;

    private GenericADEOfHole(Element value) {
        this.value = value;
    }

    public static GenericADEOfHole of(Element value) {
        return new GenericADEOfHole(value);
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
