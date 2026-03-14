/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfTrafficSpace;
import org.w3c.dom.Element;

public class GenericADEOfTrafficSpace extends ADEOfTrafficSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTrafficSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfTrafficSpace of(Element value) {
        return new GenericADEOfTrafficSpace(value);
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
