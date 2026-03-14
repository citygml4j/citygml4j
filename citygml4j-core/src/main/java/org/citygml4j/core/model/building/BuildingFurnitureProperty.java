/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingFurnitureProperty extends FeatureProperty<BuildingFurniture> implements CityGMLObject {

    public BuildingFurnitureProperty() {
    }

    public BuildingFurnitureProperty(BuildingFurniture object) {
        super(object);
    }

    public BuildingFurnitureProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingFurniture> getTargetType() {
        return BuildingFurniture.class;
    }
}
