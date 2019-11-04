package org.citygml4j.model.tunnel;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class TunnelInstallationMember extends AbstractFeatureMember<TunnelInstallation> implements CityGMLObject {

    public TunnelInstallationMember() {
    }

    public TunnelInstallationMember(TunnelInstallation object) {
        super(object);
    }

    @Override
    public Class<TunnelInstallation> getTargetType() {
        return TunnelInstallation.class;
    }
}
