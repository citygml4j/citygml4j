package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BuildingRoomMember extends AbstractFeatureMember<BuildingRoom> implements CityGMLObject {

    public BuildingRoomMember() {
    }

    public BuildingRoomMember(BuildingRoom object) {
        super(object);
    }

    @Override
    public Class<BuildingRoom> getTargetType() {
        return BuildingRoom.class;
    }
}
