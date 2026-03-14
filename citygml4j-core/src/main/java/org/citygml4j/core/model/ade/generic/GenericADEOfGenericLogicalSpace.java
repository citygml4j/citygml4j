/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.generics.ADEOfGenericLogicalSpace;
import org.w3c.dom.Element;

public class GenericADEOfGenericLogicalSpace extends ADEOfGenericLogicalSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfGenericLogicalSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfGenericLogicalSpace of(Element value) {
        return new GenericADEOfGenericLogicalSpace(value);
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
