/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractAppearance;
import org.w3c.dom.Element;

public class GenericADEOfAbstractAppearance extends ADEOfAbstractAppearance implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractAppearance(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractAppearance of(Element value) {
        return new GenericADEOfAbstractAppearance(value);
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
