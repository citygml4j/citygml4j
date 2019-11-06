package org.citygml4j.model.transportation;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class TrafficSpaceProperty extends FeatureProperty<TrafficSpace> implements CityGMLObject {

    public TrafficSpaceProperty() {
    }

    public TrafficSpaceProperty(TrafficSpace object) {
        super(object);
    }

    public TrafficSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<TrafficSpace> getTargetType() {
        return TrafficSpace.class;
    }
}
