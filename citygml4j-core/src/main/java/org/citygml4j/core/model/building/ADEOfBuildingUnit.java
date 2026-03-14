/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfBuildingUnit extends ADEProperty {

    @Override
    public final Class<BuildingUnit> getTargetType() {
        return BuildingUnit.class;
    }
}
