/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.tunnel.ADEOfTunnelFurniture;
import org.w3c.dom.Element;

public class GenericADEOfTunnelFurniture extends ADEOfTunnelFurniture implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTunnelFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnelFurniture of(Element value) {
        return new GenericADEOfTunnelFurniture(value);
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
