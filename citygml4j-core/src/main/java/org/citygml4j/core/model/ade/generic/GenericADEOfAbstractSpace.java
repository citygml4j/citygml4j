/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSpace extends ADEOfAbstractSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractSpace of(Element value) {
        return new GenericADEOfAbstractSpace(value);
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
