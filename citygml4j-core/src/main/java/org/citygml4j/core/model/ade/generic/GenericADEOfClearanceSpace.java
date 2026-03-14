/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.transportation.ADEOfClearanceSpace;
import org.w3c.dom.Element;

public class GenericADEOfClearanceSpace extends ADEOfClearanceSpace implements ADEGenericProperty {
    private Element value;

    private GenericADEOfClearanceSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfClearanceSpace of(Element value) {
        return new GenericADEOfClearanceSpace(value);
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
