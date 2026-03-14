/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfRailway;
import org.w3c.dom.Element;

public class GenericADEOfRailway extends ADEOfRailway implements ADEGenericProperty {
    private Element value;

    private GenericADEOfRailway(Element value) {
        this.value = value;
    }

    public static GenericADEOfRailway of(Element value) {
        return new GenericADEOfRailway(value);
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
