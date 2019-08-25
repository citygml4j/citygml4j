package org.citygml4j.model.construction;

import org.citygml4j.model.core.BoundarySurfaceProperty;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractConstructionSurfaceProperty extends FeatureProperty<AbstractConstructionSurface> implements BoundarySurfaceProperty<AbstractConstructionSurface> {

    public AbstractConstructionSurfaceProperty() {
    }

    public AbstractConstructionSurfaceProperty(AbstractConstructionSurface object) {
        super(object);
    }

    public AbstractConstructionSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractConstructionSurface> getTargetType() {
        return AbstractConstructionSurface.class;
    }
}
