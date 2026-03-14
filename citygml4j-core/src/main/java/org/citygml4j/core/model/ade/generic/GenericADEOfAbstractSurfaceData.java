/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.appearance.ADEOfAbstractSurfaceData;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSurfaceData extends ADEOfAbstractSurfaceData implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractSurfaceData(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractSurfaceData of(Element value) {
        return new GenericADEOfAbstractSurfaceData(value);
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
