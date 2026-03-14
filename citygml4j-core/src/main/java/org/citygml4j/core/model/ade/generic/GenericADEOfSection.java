/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfSection;
import org.w3c.dom.Element;

public class GenericADEOfSection extends ADEOfSection implements ADEGenericProperty {
    private Element value;

    private GenericADEOfSection(Element value) {
        this.value = value;
    }

    public static GenericADEOfSection of(Element value) {
        return new GenericADEOfSection(value);
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
