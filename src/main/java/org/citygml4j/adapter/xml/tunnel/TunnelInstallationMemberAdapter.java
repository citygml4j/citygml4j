package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.model.tunnel.TunnelInstallationMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class TunnelInstallationMemberAdapter extends AbstractFeatureMemberAdapter<TunnelInstallationMember> {

    @Override
    public TunnelInstallationMember createObject(QName name) throws ObjectBuildException {
        return new TunnelInstallationMember();
    }
}
