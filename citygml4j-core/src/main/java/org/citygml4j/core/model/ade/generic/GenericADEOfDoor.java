/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfDoor;
import org.w3c.dom.Element;

public class GenericADEOfDoor extends ADEOfDoor implements ADEGenericProperty {
    private Element value;

    private GenericADEOfDoor(Element value) {
        this.value = value;
    }

    public static GenericADEOfDoor of(Element value) {
        return new GenericADEOfDoor(value);
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
