package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractUnoccupiedSpaceProperty extends FeatureProperty<AbstractUnoccupiedSpace> implements CityGMLObject {

    public AbstractUnoccupiedSpaceProperty() {
    }

    public AbstractUnoccupiedSpaceProperty(AbstractUnoccupiedSpace object) {
        super(object);
    }

    public AbstractUnoccupiedSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractUnoccupiedSpace> getTargetType() {
        return AbstractUnoccupiedSpace.class;
    }
}
