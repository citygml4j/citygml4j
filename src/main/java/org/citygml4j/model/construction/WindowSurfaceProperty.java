package org.citygml4j.model.construction;

import org.citygml4j.model.core.BoundarySurfaceProperty;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class WindowSurfaceProperty extends FeatureProperty<WindowSurface> implements BoundarySurfaceProperty<WindowSurface> {

    public WindowSurfaceProperty() {
    }

    public WindowSurfaceProperty(WindowSurface object) {
        super(object);
    }

    public WindowSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<WindowSurface> getTargetType() {
        return WindowSurface.class;
    }
}
