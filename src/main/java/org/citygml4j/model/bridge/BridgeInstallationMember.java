package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BridgeInstallationMember extends AbstractFeatureMember<BridgeInstallation> implements CityGMLObject {

    public BridgeInstallationMember() {
    }

    public BridgeInstallationMember(BridgeInstallation object) {
        super(object);
    }

    @Override
    public Class<BridgeInstallation> getTargetType() {
        return BridgeInstallation.class;
    }
}
