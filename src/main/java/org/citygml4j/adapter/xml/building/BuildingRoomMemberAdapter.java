package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingRoomMember;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BuildingRoomMemberAdapter extends AbstractFeatureMemberAdapter<BuildingRoomMember> {

    @Override
    public BuildingRoomMember createObject(QName name) {
        return new BuildingRoomMember();
    }
}
