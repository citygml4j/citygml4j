package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractVersionTransitionProperty extends FeatureProperty<AbstractVersionTransition> implements CityGMLObject {

    public AbstractVersionTransitionProperty() {
    }

    public AbstractVersionTransitionProperty(AbstractVersionTransition object) {
        super(object);
    }

    public AbstractVersionTransitionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractVersionTransition> getTargetType() {
        return AbstractVersionTransition.class;
    }
}
