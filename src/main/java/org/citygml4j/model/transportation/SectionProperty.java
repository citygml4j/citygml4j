package org.citygml4j.model.transportation;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class SectionProperty extends FeatureProperty<Section> implements CityGMLObject {

    public SectionProperty() {
    }

    public SectionProperty(Section object) {
        super(object);
    }

    public SectionProperty(String href) {
        super(href);
    }

    @Override
    public Class<Section> getTargetType() {
        return Section.class;
    }
}
