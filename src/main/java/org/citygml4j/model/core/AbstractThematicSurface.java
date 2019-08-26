package org.citygml4j.model.core;

import org.citygml4j.model.pointcloud.PointCloudProperty;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

import java.util.List;

public abstract class AbstractThematicSurface extends AbstractCityObject {
    private List<QualifiedAreaProperty> areas;
    private MultiCurveProperty lod0MultiCurve;
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiSurfaceProperty lod2MultiSurface;
    private MultiSurfaceProperty lod3MultiSurface;
    private PointCloudProperty pointCloud;
    private List<ADEPropertyOfAbstractThematicSurface> adeProperties;

    public List<QualifiedAreaProperty> getAreas() {
        if (areas == null)
            areas = new ChildList<>(this);

        return areas;
    }

    public void setAreas(List<QualifiedAreaProperty> areas) {
        this.areas = asChild(areas);
    }

    public MultiCurveProperty getLod0MultiCurve() {
        return lod0MultiCurve;
    }

    public void setLod0MultiCurve(MultiCurveProperty lod0MultiCurve) {
        this.lod0MultiCurve = asChild(lod0MultiCurve);
    }

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    public MultiSurfaceProperty getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
        this.lod2MultiSurface = asChild(lod2MultiSurface);
    }

    public MultiSurfaceProperty getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
        this.lod3MultiSurface = asChild(lod3MultiSurface);
    }

    public PointCloudProperty getPointCloud() {
        return pointCloud;
    }

    public void setPointCloud(PointCloudProperty pointCloud) {
        this.pointCloud = asChild(pointCloud);
    }

    public List<ADEPropertyOfAbstractThematicSurface> getADEPropertiesOfAbstractThematicSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractThematicSurface(List<ADEPropertyOfAbstractThematicSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
