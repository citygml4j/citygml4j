package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractLogicalSpaceProperty extends FeatureProperty<AbstractLogicalSpace> implements CityGMLObject {

    public AbstractLogicalSpaceProperty() {
    }

    public AbstractLogicalSpaceProperty(AbstractLogicalSpace object) {
        super(object);
    }

    public AbstractLogicalSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractLogicalSpace> getTargetType() {
        return AbstractLogicalSpace.class;
    }
}
