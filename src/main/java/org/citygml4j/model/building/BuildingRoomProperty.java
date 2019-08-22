package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
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
