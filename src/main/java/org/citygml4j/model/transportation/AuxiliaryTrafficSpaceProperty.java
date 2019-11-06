package org.citygml4j.model.transportation;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AuxiliaryTrafficSpaceProperty extends FeatureProperty<AuxiliaryTrafficSpace> implements CityGMLObject {

    public AuxiliaryTrafficSpaceProperty() {
    }

    public AuxiliaryTrafficSpaceProperty(AuxiliaryTrafficSpace object) {
        super(object);
    }

    public AuxiliaryTrafficSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AuxiliaryTrafficSpace> getTargetType() {
        return AuxiliaryTrafficSpace.class;
    }
}
