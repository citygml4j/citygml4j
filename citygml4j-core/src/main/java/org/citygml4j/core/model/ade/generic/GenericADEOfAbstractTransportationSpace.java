/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfAbstractTransportationSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTransportationSpace extends ADEOfAbstractTransportationSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractTransportationSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractTransportationSpace of(Element value) {
        return new GenericADEOfAbstractTransportationSpace(value);
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
