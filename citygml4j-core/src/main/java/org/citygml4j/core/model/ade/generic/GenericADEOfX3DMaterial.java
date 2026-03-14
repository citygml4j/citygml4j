/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.appearance.ADEOfX3DMaterial;
import org.w3c.dom.Element;

public class GenericADEOfX3DMaterial extends ADEOfX3DMaterial implements ADEGenericProperty {
    private Element value;

    private GenericADEOfX3DMaterial(Element value) {
        this.value = value;
    }

    public static GenericADEOfX3DMaterial of(Element value) {
        return new GenericADEOfX3DMaterial(value);
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
