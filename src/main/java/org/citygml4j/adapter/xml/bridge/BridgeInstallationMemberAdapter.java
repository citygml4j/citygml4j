package org.citygml4j.adapter.xml.bridge;

import org.citygml4j.model.bridge.BridgeInstallationMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BridgeInstallationMemberAdapter extends AbstractFeatureMemberAdapter<BridgeInstallationMember> {

    @Override
    public BridgeInstallationMember createObject(QName name) throws ObjectBuildException {
        return new BridgeInstallationMember();
    }
}
