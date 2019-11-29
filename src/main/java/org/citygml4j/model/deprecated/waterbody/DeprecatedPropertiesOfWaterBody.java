package org.citygml4j.model.deprecated.waterbody;

import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;

public class DeprecatedPropertiesOfWaterBody extends DeprecatedPropertiesOfAbstractCityObject {
    private MultiCurveProperty lod1MultiCurve;
    private MultiSurfaceProperty lod1MultiSurface;
    private SolidProperty lod4Solid;

    public MultiCurveProperty getLod1MultiCurve() {
        return lod1MultiCurve;
    }

    public void setLod1MultiCurve(MultiCurveProperty lod1MultiCurve) {
        this.lod1MultiCurve = asChild(lod1MultiCurve);
    }

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    public SolidProperty getLod4Solid() {
        return lod4Solid;
    }

    public void setLod4Solid(SolidProperty lod4Solid) {
        this.lod4Solid = asChild(lod4Solid);
    }
}
