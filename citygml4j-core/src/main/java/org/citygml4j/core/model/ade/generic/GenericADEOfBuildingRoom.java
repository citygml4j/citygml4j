/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfBuildingRoom;
import org.w3c.dom.Element;

public class GenericADEOfBuildingRoom extends ADEOfBuildingRoom implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBuildingRoom(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingRoom of(Element value) {
        return new GenericADEOfBuildingRoom(value);
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
