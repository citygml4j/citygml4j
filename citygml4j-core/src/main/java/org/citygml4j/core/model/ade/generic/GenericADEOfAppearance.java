/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.appearance.ADEOfAppearance;
import org.w3c.dom.Element;

public class GenericADEOfAppearance extends ADEOfAppearance implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAppearance(Element value) {
        this.value = value;
    }

    public static GenericADEOfAppearance of(Element value) {
        return new GenericADEOfAppearance(value);
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
