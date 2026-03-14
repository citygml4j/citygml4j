/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfBuilding;
import org.w3c.dom.Element;

public class GenericADEOfBuilding extends ADEOfBuilding implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBuilding(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuilding of(Element value) {
        return new GenericADEOfBuilding(value);
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
