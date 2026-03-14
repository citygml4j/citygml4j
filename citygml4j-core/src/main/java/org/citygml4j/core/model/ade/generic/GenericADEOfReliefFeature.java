/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.relief.ADEOfReliefFeature;
import org.w3c.dom.Element;

public class GenericADEOfReliefFeature extends ADEOfReliefFeature implements ADEGenericProperty {
    private Element value;

    private GenericADEOfReliefFeature(Element value) {
        this.value = value;
    }

    public static GenericADEOfReliefFeature of(Element value) {
        return new GenericADEOfReliefFeature(value);
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
