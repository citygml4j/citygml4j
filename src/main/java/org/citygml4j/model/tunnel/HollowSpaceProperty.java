package org.citygml4j.model.tunnel;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class HollowSpaceProperty extends FeatureProperty<HollowSpace> implements CityGMLObject {

    public HollowSpaceProperty() {
    }

    public HollowSpaceProperty(HollowSpace object) {
        super(object);
    }

    public HollowSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<HollowSpace> getTargetType() {
        return HollowSpace.class;
    }
}
