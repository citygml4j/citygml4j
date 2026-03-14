/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfClosureSurface;
import org.w3c.dom.Element;

public class GenericADEOfClosureSurface extends ADEOfClosureSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfClosureSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfClosureSurface of(Element value) {
        return new GenericADEOfClosureSurface(value);
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
