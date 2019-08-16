package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class DynamizerProperty extends FeatureProperty<AbstractDynamizer> implements CityGMLObject {

    public DynamizerProperty() {
    }

    public DynamizerProperty(AbstractDynamizer object) {
        super(object);
    }

    public DynamizerProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractDynamizer> getTargetType() {
        return AbstractDynamizer.class;
    }
}
