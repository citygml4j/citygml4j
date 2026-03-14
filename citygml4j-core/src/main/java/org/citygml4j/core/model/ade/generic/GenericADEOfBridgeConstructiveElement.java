/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.bridge.ADEOfBridgeConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfBridgeConstructiveElement extends ADEOfBridgeConstructiveElement implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBridgeConstructiveElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfBridgeConstructiveElement of(Element value) {
        return new GenericADEOfBridgeConstructiveElement(value);
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
