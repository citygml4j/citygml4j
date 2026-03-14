/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfHoleSurface;
import org.w3c.dom.Element;

public class GenericADEOfHoleSurface extends ADEOfHoleSurface implements ADEGenericProperty {
    private Element value;

    private GenericADEOfHoleSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfHoleSurface of(Element value) {
        return new GenericADEOfHoleSurface(value);
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
