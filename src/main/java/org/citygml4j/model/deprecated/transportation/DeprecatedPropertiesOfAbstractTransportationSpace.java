package org.citygml4j.model.deprecated.transportation;

import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplexProperty;

public class DeprecatedPropertiesOfAbstractTransportationSpace extends DeprecatedPropertiesOfAbstractCityObject {
    private GeometricComplexProperty lod0Network;
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiSurfaceProperty lod4MultiSurface;

    public GeometricComplexProperty getLod0Network() {
        return lod0Network;
    }

    public void setLod0Network(GeometricComplexProperty lod0Network) {
        this.lod0Network = asChild(lod0Network);
    }

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = asChild(lod4MultiSurface);
    }
}
