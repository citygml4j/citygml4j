/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.generics.ADEOfGenericUnoccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEOfGenericUnoccupiedSpace extends ADEOfGenericUnoccupiedSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfGenericUnoccupiedSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfGenericUnoccupiedSpace of(Element value) {
        return new GenericADEOfGenericUnoccupiedSpace(value);
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
