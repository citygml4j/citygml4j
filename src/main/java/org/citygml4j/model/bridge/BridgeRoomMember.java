package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BridgeRoomMember extends AbstractFeatureMember<BridgeRoom> implements CityGMLObject {

    public BridgeRoomMember() {
    }

    public BridgeRoomMember(BridgeRoom object) {
        super(object);
    }

    @Override
    public Class<BridgeRoom> getTargetType() {
        return BridgeRoom.class;
    }
}
