package org.citygml4j.model.transportation;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class IntersectionProperty extends FeatureProperty<Intersection> implements CityGMLObject {

    public IntersectionProperty() {
    }

    public IntersectionProperty(Intersection object) {
        super(object);
    }

    public IntersectionProperty(String href) {
        super(href);
    }

    @Override
    public Class<Intersection> getTargetType() {
        return Intersection.class;
    }
}
