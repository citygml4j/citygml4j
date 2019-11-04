package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BridgeFurnitureMember extends AbstractFeatureMember<BridgeFurniture> implements CityGMLObject {

    public BridgeFurnitureMember() {
    }

    public BridgeFurnitureMember(BridgeFurniture object) {
        super(object);
    }

    @Override
    public Class<BridgeFurniture> getTargetType() {
        return BridgeFurniture.class;
    }
}
