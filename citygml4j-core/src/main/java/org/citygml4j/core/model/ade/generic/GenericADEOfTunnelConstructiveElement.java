/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.tunnel.ADEOfTunnelConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfTunnelConstructiveElement extends ADEOfTunnelConstructiveElement implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTunnelConstructiveElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnelConstructiveElement of(Element value) {
        return new GenericADEOfTunnelConstructiveElement(value);
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
