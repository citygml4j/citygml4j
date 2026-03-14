/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.tunnel.ADEOfTunnelPart;
import org.w3c.dom.Element;

public class GenericADEOfTunnelPart extends ADEOfTunnelPart implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTunnelPart(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnelPart of(Element value) {
        return new GenericADEOfTunnelPart(value);
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
