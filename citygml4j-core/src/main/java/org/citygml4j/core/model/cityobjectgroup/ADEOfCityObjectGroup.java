/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.cityobjectgroup;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfCityObjectGroup extends ADEProperty {

    @Override
    public final Class<CityObjectGroup> getTargetType() {
        return CityObjectGroup.class;
    }
}
