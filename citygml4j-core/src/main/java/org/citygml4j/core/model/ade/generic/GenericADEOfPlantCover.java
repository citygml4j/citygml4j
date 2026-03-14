/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.vegetation.ADEOfPlantCover;
import org.w3c.dom.Element;

public class GenericADEOfPlantCover extends ADEOfPlantCover implements ADEGenericProperty {
    private Element value;

    private GenericADEOfPlantCover(Element value) {
        this.value = value;
    }

    public static GenericADEOfPlantCover of(Element value) {
        return new GenericADEOfPlantCover(value);
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
