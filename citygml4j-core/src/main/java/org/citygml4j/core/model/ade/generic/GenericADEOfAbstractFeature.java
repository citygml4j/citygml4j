/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractFeature;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFeature extends ADEOfAbstractFeature implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractFeature(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractFeature of(Element value) {
        return new GenericADEOfAbstractFeature(value);
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
