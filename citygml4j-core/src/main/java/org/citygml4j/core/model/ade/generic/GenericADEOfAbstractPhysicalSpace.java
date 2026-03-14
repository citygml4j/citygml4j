/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractPhysicalSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractPhysicalSpace extends ADEOfAbstractPhysicalSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractPhysicalSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractPhysicalSpace of(Element value) {
        return new GenericADEOfAbstractPhysicalSpace(value);
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
