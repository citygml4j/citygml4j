/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingRoomProperty extends FeatureProperty<BuildingRoom> implements CityGMLObject {

    public BuildingRoomProperty() {
    }

    public BuildingRoomProperty(BuildingRoom object) {
        super(object);
    }

    public BuildingRoomProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingRoom> getTargetType() {
        return BuildingRoom.class;
    }
}
