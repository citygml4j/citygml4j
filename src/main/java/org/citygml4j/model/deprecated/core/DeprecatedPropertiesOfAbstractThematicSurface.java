package org.citygml4j.model.deprecated.core;

import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

public class DeprecatedPropertiesOfAbstractThematicSurface extends DeprecatedPropertiesOfAbstractCityObject {
    private MultiSurfaceProperty lod4MultiSurface;

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = asChild(lod4MultiSurface);
    }
}
