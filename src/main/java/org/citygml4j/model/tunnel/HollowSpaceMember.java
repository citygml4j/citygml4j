package org.citygml4j.model.tunnel;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class HollowSpaceMember extends AbstractFeatureMember<HollowSpace> implements CityGMLObject {

    public HollowSpaceMember() {
    }

    public HollowSpaceMember(HollowSpace object) {
        super(object);
    }

    @Override
    public Class<HollowSpace> getTargetType() {
        return HollowSpace.class;
    }
}
