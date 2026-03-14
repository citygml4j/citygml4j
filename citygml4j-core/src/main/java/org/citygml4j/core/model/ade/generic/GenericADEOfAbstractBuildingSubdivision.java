/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfAbstractBuildingSubdivision;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBuildingSubdivision extends ADEOfAbstractBuildingSubdivision implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractBuildingSubdivision(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractBuildingSubdivision of(Element value) {
        return new GenericADEOfAbstractBuildingSubdivision(value);
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
