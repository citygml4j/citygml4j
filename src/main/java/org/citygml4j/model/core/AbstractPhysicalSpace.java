package org.citygml4j.model.core;

import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;

import java.util.List;

public abstract class AbstractPhysicalSpace extends AbstractSpace {
    private MultiCurveProperty lod1TerrainIntersectionCurve;
    private MultiCurveProperty lod2TerrainIntersectionCurve;
    private MultiCurveProperty lod3TerrainIntersectionCurve;
    private AbstractPointCloudProperty pointCloud;
    private List<ADEPropertyOfAbstractPhysicalSpace> adeProperties;

    public MultiCurveProperty getLod1TerrainIntersectionCurve() {
        return lod1TerrainIntersectionCurve;
    }

    public void setLod1TerrainIntersectionCurve(MultiCurveProperty lod1TerrainIntersectionCurve) {
        this.lod1TerrainIntersectionCurve = asChild(lod1TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod2TerrainIntersectionCurve() {
        return lod2TerrainIntersectionCurve;
    }

    public void setLod2TerrainIntersectionCurve(MultiCurveProperty lod2TerrainIntersectionCurve) {
        this.lod2TerrainIntersectionCurve = asChild(lod2TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod3TerrainIntersectionCurve() {
        return lod3TerrainIntersectionCurve;
    }

    public void setLod3TerrainIntersectionCurve(MultiCurveProperty lod3TerrainIntersectionCurve) {
        this.lod3TerrainIntersectionCurve = asChild(lod3TerrainIntersectionCurve);
    }

    public AbstractPointCloudProperty getPointCloud() {
        return pointCloud;
    }

    public void setPointCloud(AbstractPointCloudProperty pointCloud) {
        this.pointCloud = asChild(pointCloud);
    }

    public List<ADEPropertyOfAbstractPhysicalSpace> getADEPropertiesOfAbstractPhysicalSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractPhysicalSpace(List<ADEPropertyOfAbstractPhysicalSpace> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}