package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.tunnel.TunnelConstructiveElementMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class TunnelConstructiveElementMemberAdapter extends AbstractFeatureMemberAdapter<TunnelConstructiveElementMember> {

    @Override
    public TunnelConstructiveElementMember createObject(QName name) throws ObjectBuildException {
        return new TunnelConstructiveElementMember();
    }
}
