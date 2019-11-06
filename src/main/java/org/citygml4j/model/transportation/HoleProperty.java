package org.citygml4j.model.transportation;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class HoleProperty extends FeatureProperty<Hole> implements CityGMLObject {

    public HoleProperty() {
    }

    public HoleProperty(Hole object) {
        super(object);
    }

    public HoleProperty(String href) {
        super(href);
    }

    @Override
    public Class<Hole> getTargetType() {
        return Hole.class;
    }
}
