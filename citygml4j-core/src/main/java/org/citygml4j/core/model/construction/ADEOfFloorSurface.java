/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfFloorSurface extends ADEProperty {

    @Override
    public final Class<FloorSurface> getTargetType() {
        return FloorSurface.class;
    }
}
