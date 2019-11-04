package org.citygml4j.model.tunnel;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class TunnelConstructiveElementMember extends AbstractFeatureMember<TunnelConstructiveElement> implements CityGMLObject {

    public TunnelConstructiveElementMember() {
    }

    public TunnelConstructiveElementMember(TunnelConstructiveElement object) {
        super(object);
    }

    @Override
    public Class<TunnelConstructiveElement> getTargetType() {
        return TunnelConstructiveElement.class;
    }
}
