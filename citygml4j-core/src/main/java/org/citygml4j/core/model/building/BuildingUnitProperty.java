/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingUnitProperty extends FeatureProperty<BuildingUnit> implements CityGMLObject {

    public BuildingUnitProperty() {
    }

    public BuildingUnitProperty(BuildingUnit object) {
        super(object);
    }

    public BuildingUnitProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingUnit> getTargetType() {
        return BuildingUnit.class;
    }
}
