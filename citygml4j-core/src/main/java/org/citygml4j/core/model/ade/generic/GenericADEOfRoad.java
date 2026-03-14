/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfRoad;
import org.w3c.dom.Element;

public class GenericADEOfRoad extends ADEOfRoad implements ADEGenericProperty {
    private Element value;

    private GenericADEOfRoad(Element value) {
        this.value = value;
    }

    public static GenericADEOfRoad of(Element value) {
        return new GenericADEOfRoad(value);
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
