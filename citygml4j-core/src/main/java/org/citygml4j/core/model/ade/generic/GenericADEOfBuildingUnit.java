/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfBuildingUnit;
import org.w3c.dom.Element;

public class GenericADEOfBuildingUnit extends ADEOfBuildingUnit implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBuildingUnit(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingUnit of(Element value) {
        return new GenericADEOfBuildingUnit(value);
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
