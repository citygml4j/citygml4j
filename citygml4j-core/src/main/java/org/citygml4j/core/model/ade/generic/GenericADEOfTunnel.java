/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.tunnel.ADEOfTunnel;
import org.w3c.dom.Element;

public class GenericADEOfTunnel extends ADEOfTunnel implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTunnel(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnel of(Element value) {
        return new GenericADEOfTunnel(value);
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
