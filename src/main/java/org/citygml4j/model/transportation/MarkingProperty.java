package org.citygml4j.model.transportation;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class MarkingProperty extends FeatureProperty<Marking> implements CityGMLObject {

    public MarkingProperty() {
    }

    public MarkingProperty(Marking object) {
        super(object);
    }

    public MarkingProperty(String href) {
        super(href);
    }

    @Override
    public Class<Marking> getTargetType() {
        return Marking.class;
    }
}
