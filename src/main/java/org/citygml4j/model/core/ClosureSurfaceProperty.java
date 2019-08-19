package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class ClosureSurfaceProperty extends FeatureProperty<ClosureSurface> implements CityGMLObject {

    public ClosureSurfaceProperty() {
    }

    public ClosureSurfaceProperty(ClosureSurface object) {
        super(object);
    }

    public ClosureSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<ClosureSurface> getTargetType() {
        return ClosureSurface.class;
    }
}
