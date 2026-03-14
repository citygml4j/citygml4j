/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfBuildingConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfBuildingConstructiveElement extends ADEOfBuildingConstructiveElement implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBuildingConstructiveElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingConstructiveElement of(Element value) {
        return new GenericADEOfBuildingConstructiveElement(value);
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
