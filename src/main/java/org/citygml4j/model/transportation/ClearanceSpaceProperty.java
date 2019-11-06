package org.citygml4j.model.transportation;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class ClearanceSpaceProperty extends FeatureProperty<ClearanceSpace> implements CityGMLObject {

    public ClearanceSpaceProperty() {
    }

    public ClearanceSpaceProperty(ClearanceSpace object) {
        super(object);
    }

    public ClearanceSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<ClearanceSpace> getTargetType() {
        return ClearanceSpace.class;
    }
}
