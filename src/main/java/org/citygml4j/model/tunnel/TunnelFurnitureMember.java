package org.citygml4j.model.tunnel;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class TunnelFurnitureMember extends AbstractFeatureMember<TunnelFurniture> implements CityGMLObject {

    public TunnelFurnitureMember() {
    }

    public TunnelFurnitureMember(TunnelFurniture object) {
        super(object);
    }

    @Override
    public Class<TunnelFurniture> getTargetType() {
        return TunnelFurniture.class;
    }
}
