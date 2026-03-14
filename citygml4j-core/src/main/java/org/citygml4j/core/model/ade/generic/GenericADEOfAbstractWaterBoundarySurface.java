/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.waterbody.ADEOfAbstractWaterBoundarySurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractWaterBoundarySurface extends ADEOfAbstractWaterBoundarySurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractWaterBoundarySurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractWaterBoundarySurface of(Element value) {
        return new GenericADEOfAbstractWaterBoundarySurface(value);
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
