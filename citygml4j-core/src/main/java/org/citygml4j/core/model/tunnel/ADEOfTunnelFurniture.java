/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.tunnel;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfTunnelFurniture extends ADEProperty {

    @Override
    public final Class<TunnelFurniture> getTargetType() {
        return TunnelFurniture.class;
    }
}
