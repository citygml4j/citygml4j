/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.building.ADEOfBuildingInstallation;
import org.w3c.dom.Element;

public class GenericADEOfBuildingInstallation extends ADEOfBuildingInstallation implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBuildingInstallation(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingInstallation of(Element value) {
        return new GenericADEOfBuildingInstallation(value);
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
