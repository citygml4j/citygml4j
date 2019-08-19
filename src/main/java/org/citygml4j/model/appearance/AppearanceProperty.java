package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AppearanceProperty extends FeatureProperty<Appearance> implements CityGMLObject {

    public AppearanceProperty() {
    }

    public AppearanceProperty(Appearance object) {
        super(object);
    }

    public AppearanceProperty(String href) {
        super(href);
    }

    @Override
    public Class<Appearance> getTargetType() {
        return Appearance.class;
    }
}
