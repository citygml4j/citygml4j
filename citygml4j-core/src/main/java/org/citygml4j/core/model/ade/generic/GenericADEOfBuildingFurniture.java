/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfBuildingFurniture;
import org.w3c.dom.Element;

public class GenericADEOfBuildingFurniture extends ADEOfBuildingFurniture implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBuildingFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingFurniture of(Element value) {
        return new GenericADEOfBuildingFurniture(value);
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
