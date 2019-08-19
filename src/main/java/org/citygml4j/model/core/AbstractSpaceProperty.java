package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractSpaceProperty extends FeatureProperty<AbstractSpace> implements CityGMLObject {

    public AbstractSpaceProperty() {
    }

    public AbstractSpaceProperty(AbstractSpace object) {
        super(object);
    }

    public AbstractSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractSpace> getTargetType() {
        return AbstractSpace.class;
    }
}
