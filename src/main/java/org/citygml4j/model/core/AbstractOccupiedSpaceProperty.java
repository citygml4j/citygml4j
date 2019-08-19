package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractOccupiedSpaceProperty extends FeatureProperty<AbstractOccupiedSpace> implements CityGMLObject {

    public AbstractOccupiedSpaceProperty() {
    }

    public AbstractOccupiedSpaceProperty(AbstractOccupiedSpace object) {
        super(object);
    }

    public AbstractOccupiedSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractOccupiedSpace> getTargetType() {
        return AbstractOccupiedSpace.class;
    }
}
