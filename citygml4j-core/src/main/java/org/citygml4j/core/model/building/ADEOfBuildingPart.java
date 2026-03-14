/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfBuildingPart extends ADEProperty {

    @Override
    public final Class<BuildingPart> getTargetType() {
        return BuildingPart.class;
    }
}
