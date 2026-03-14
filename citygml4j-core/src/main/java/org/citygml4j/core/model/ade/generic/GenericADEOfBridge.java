/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.bridge.ADEOfBridge;
import org.w3c.dom.Element;

public class GenericADEOfBridge extends ADEOfBridge implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBridge(Element value) {
        this.value = value;
    }

    public static GenericADEOfBridge of(Element value) {
        return new GenericADEOfBridge(value);
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
