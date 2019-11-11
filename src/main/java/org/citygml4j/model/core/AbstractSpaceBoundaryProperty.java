package org.citygml4j.model.core;

import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractSpaceBoundaryProperty extends FeatureProperty<AbstractSpaceBoundary> {

    public AbstractSpaceBoundaryProperty() {
    }

    public AbstractSpaceBoundaryProperty(AbstractSpaceBoundary object) {
        super(object);
    }

    public AbstractSpaceBoundaryProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractSpaceBoundary> getTargetType() {
        return AbstractSpaceBoundary.class;
    }
}
