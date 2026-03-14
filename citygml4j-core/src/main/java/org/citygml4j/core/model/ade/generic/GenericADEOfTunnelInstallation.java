/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.tunnel.ADEOfTunnelInstallation;
import org.w3c.dom.Element;

public class GenericADEOfTunnelInstallation extends ADEOfTunnelInstallation implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTunnelInstallation(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnelInstallation of(Element value) {
        return new GenericADEOfTunnelInstallation(value);
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
