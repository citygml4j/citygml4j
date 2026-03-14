/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.bridge.ADEOfBridgePart;
import org.w3c.dom.Element;

public class GenericADEOfBridgePart extends ADEOfBridgePart implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBridgePart(Element value) {
        this.value = value;
    }

    public static GenericADEOfBridgePart of(Element value) {
        return new GenericADEOfBridgePart(value);
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
