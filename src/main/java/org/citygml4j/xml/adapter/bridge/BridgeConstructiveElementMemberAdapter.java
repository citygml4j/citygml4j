package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.bridge.BridgeConstructiveElementMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BridgeConstructiveElementMemberAdapter extends AbstractFeatureMemberAdapter<BridgeConstructiveElementMember> {

    @Override
    public BridgeConstructiveElementMember createObject(QName name) throws ObjectBuildException {
        return new BridgeConstructiveElementMember();
    }
}
