package org.citygml4j.model.versioning;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class VersionTransitionProperty extends FeatureProperty<AbstractVersionTransition> implements CityGMLObject {

    public VersionTransitionProperty() {
    }

    public VersionTransitionProperty(AbstractVersionTransition object) {
        super(object);
    }

    public VersionTransitionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractVersionTransition> getTargetType() {
        return AbstractVersionTransition.class;
    }
}
