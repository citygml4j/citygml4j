package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractPhysicalSpaceProperty extends FeatureProperty<AbstractPhysicalSpace> implements CityGMLObject {

    public AbstractPhysicalSpaceProperty() {
    }

    public AbstractPhysicalSpaceProperty(AbstractPhysicalSpace object) {
        super(object);
    }

    public AbstractPhysicalSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractPhysicalSpace> getTargetType() {
        return AbstractPhysicalSpace.class;
    }
}
