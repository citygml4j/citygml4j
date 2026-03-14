/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.cityfurniture;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfCityFurniture extends ADEProperty {

    @Override
    public final Class<CityFurniture> getTargetType() {
        return CityFurniture.class;
    }
}
