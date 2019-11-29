package org.citygml4j.model.deprecated.vegetation;

import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolidProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

public class DeprecatedPropertiesOfPlantCover extends DeprecatedPropertiesOfAbstractCityObject {
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiSurfaceProperty lod4MultiSurface;
    private MultiSolidProperty lod1MultiSolid;
    private MultiSolidProperty lod2MultiSolid;
    private MultiSolidProperty lod3MultiSolid;
    private MultiSolidProperty lod4MultiSolid;

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

    public MultiSolidProperty getLod1MultiSolid() {
        return lod1MultiSolid;
    }

    public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid) {
        this.lod1MultiSolid = asChild(lod1MultiSolid);
    }

    public MultiSolidProperty getLod2MultiSolid() {
        return lod2MultiSolid;
    }

    public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid) {
        this.lod2MultiSolid = asChild(lod2MultiSolid);
    }

    public MultiSolidProperty getLod3MultiSolid() {
        return lod3MultiSolid;
    }

    public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid) {
        this.lod3MultiSolid = asChild(lod3MultiSolid);
    }

    public MultiSolidProperty getLod4MultiSolid() {
        return lod4MultiSolid;
    }

    public void setLod4MultiSolid(MultiSolidProperty lod4MultiSolid) {
        this.lod4MultiSolid = asChild(lod4MultiSolid);
    }
}
