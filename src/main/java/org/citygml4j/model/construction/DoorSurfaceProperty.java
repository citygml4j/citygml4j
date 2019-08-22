package org.citygml4j.model.construction;

import org.citygml4j.model.core.SpaceBoundaryProperty;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class DoorSurfaceProperty extends FeatureProperty<DoorSurface> implements SpaceBoundaryProperty<DoorSurface> {

    public DoorSurfaceProperty() {
    }

    public DoorSurfaceProperty(DoorSurface object) {
        super(object);
    }

    public DoorSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<DoorSurface> getTargetType() {
        return DoorSurface.class;
    }
}
