/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.waterbody.ADEOfWaterSurface;
import org.w3c.dom.Element;

public class GenericADEOfWaterSurface extends ADEOfWaterSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfWaterSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfWaterSurface of(Element value) {
        return new GenericADEOfWaterSurface(value);
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
