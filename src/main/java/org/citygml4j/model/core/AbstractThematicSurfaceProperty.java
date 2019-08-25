package org.citygml4j.model.core;

import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractThematicSurfaceProperty extends FeatureProperty<AbstractThematicSurface> implements BoundarySurfaceProperty<AbstractThematicSurface> {

    public AbstractThematicSurfaceProperty() {
    }

    public AbstractThematicSurfaceProperty(AbstractThematicSurface object) {
        super(object);
    }

    public AbstractThematicSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractThematicSurface> getTargetType() {
        return AbstractThematicSurface.class;
    }
}
