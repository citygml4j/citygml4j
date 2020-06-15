package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.bridge.BridgeInstallationMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BridgeInstallationMemberAdapter extends AbstractFeatureMemberAdapter<BridgeInstallationMember> {

    @Override
    public BridgeInstallationMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeInstallationMember();
    }
}
