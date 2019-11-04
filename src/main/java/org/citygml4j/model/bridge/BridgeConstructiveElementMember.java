package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BridgeConstructiveElementMember extends AbstractFeatureMember<BridgeConstructiveElement> implements CityGMLObject {

    public BridgeConstructiveElementMember() {
    }

    public BridgeConstructiveElementMember(BridgeConstructiveElement object) {
        super(object);
    }

    @Override
    public Class<BridgeConstructiveElement> getTargetType() {
        return BridgeConstructiveElement.class;
    }
}
