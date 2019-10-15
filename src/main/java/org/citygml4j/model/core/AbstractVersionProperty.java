package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractVersionProperty extends FeatureProperty<AbstractVersion> implements CityGMLObject {

    public AbstractVersionProperty() {
    }

    public AbstractVersionProperty(AbstractVersion object) {
        super(object);
    }

    public AbstractVersionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractVersion> getTargetType() {
        return AbstractVersion.class;
    }
}
