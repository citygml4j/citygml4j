package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.model.tunnel.TunnelFurnitureMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class TunnelFurnitureMemberAdapter extends AbstractFeatureMemberAdapter<TunnelFurnitureMember> {

    @Override
    public TunnelFurnitureMember createObject(QName name) throws ObjectBuildException {
        return new TunnelFurnitureMember();
    }
}
