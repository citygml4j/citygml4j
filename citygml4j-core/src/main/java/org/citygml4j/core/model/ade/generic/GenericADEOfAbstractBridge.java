/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.bridge.ADEOfAbstractBridge;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBridge extends ADEOfAbstractBridge implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractBridge(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractBridge of(Element value) {
        return new GenericADEOfAbstractBridge(value);
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
