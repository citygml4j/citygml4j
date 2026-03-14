/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.landuse;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfLandUse extends ADEProperty {

    @Override
    public final Class<LandUse> getTargetType() {
        return LandUse.class;
    }
}
