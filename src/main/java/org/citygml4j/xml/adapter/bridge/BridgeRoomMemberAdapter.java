package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.bridge.BridgeRoomMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BridgeRoomMemberAdapter extends AbstractFeatureMemberAdapter<BridgeRoomMember> {

    @Override
    public BridgeRoomMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeRoomMember();
    }
}
