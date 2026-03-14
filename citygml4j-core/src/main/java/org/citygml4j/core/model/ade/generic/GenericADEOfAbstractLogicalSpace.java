/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractLogicalSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractLogicalSpace extends ADEOfAbstractLogicalSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractLogicalSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractLogicalSpace of(Element value) {
        return new GenericADEOfAbstractLogicalSpace(value);
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
