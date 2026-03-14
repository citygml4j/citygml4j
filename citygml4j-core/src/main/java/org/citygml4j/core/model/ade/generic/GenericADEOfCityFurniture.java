/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.cityfurniture.ADEOfCityFurniture;
import org.w3c.dom.Element;

public class GenericADEOfCityFurniture extends ADEOfCityFurniture implements ADEGenericProperty {
    private Element value;

    private GenericADEOfCityFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfCityFurniture of(Element value) {
        return new GenericADEOfCityFurniture(value);
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
