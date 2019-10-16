package org.citygml4j.model.landuse;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class LandUseProperty extends FeatureProperty<LandUse> implements CityGMLObject {

    public LandUseProperty() {
    }

    public LandUseProperty(LandUse object) {
        super(object);
    }

    public LandUseProperty(String href) {
        super(href);
    }

    @Override
    public Class<LandUse> getTargetType() {
        return LandUse.class;
    }
}
