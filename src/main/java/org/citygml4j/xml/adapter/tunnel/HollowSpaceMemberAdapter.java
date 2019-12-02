package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.tunnel.HollowSpaceMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class HollowSpaceMemberAdapter extends AbstractFeatureMemberAdapter<HollowSpaceMember> {

    @Override
    public HollowSpaceMember createObject(QName name) throws ObjectBuildException {
        return new HollowSpaceMember();
    }
}
