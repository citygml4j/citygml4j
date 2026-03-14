/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractDynamizer;
import org.w3c.dom.Element;

public class GenericADEOfAbstractDynamizer extends ADEOfAbstractDynamizer implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractDynamizer(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractDynamizer of(Element value) {
        return new GenericADEOfAbstractDynamizer(value);
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
