/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.waterbody;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfWaterSurface extends ADEProperty {

    @Override
    public final Class<WaterSurface> getTargetType() {
        return WaterSurface.class;
    }
}
