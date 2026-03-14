/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfAbstractBuilding;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBuilding extends ADEOfAbstractBuilding implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractBuilding(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractBuilding of(Element value) {
        return new GenericADEOfAbstractBuilding(value);
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
