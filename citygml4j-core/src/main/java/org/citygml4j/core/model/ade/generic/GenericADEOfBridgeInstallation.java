/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.bridge.ADEOfBridgeInstallation;
import org.w3c.dom.Element;

public class GenericADEOfBridgeInstallation extends ADEOfBridgeInstallation implements ADEGenericProperty {
    private Element value;

    private GenericADEOfBridgeInstallation(Element value) {
        this.value = value;
    }

    public static GenericADEOfBridgeInstallation of(Element value) {
        return new GenericADEOfBridgeInstallation(value);
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
