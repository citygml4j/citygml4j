package org.citygml4j.model.construction;

import org.citygml4j.model.core.BoundarySurfaceProperty;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class DoorSurfaceProperty extends FeatureProperty<DoorSurface> implements BoundarySurfaceProperty<DoorSurface> {

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
