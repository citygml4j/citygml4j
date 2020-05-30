package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractPhysicalSpace extends AbstractSpace {
    private MultiCurveProperty lod1TerrainIntersectionCurve;
    private MultiCurveProperty lod2TerrainIntersectionCurve;
    private MultiCurveProperty lod3TerrainIntersectionCurve;
    private AbstractPointCloudProperty pointCloud;
    private List<ADEOfAbstractPhysicalSpace> adeOfAbstractPhysicalSpace;

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

    public List<ADEOfAbstractPhysicalSpace> getADEOfAbstractPhysicalSpace() {
        if (adeOfAbstractPhysicalSpace == null)
            adeOfAbstractPhysicalSpace = new ChildList<>(this);

        return adeOfAbstractPhysicalSpace;
    }

    public void setADEOfAbstractPhysicalSpace(List<ADEOfAbstractPhysicalSpace> adeOfAbstractPhysicalSpace) {
        this.adeOfAbstractPhysicalSpace = asChild(adeOfAbstractPhysicalSpace);
    }

    public MultiCurveProperty getTerrainIntersectionCurve(int lod) {
        switch (lod) {
            case 1:
                return getLod1TerrainIntersectionCurve();
            case 2:
                return getLod2TerrainIntersectionCurve();
            case 3:
                return getLod3TerrainIntersectionCurve();
            default:
                return null;
        }
    }

    public boolean setTerrainIntersectionCurve(int lod, MultiCurveProperty property) {
        switch (lod) {
            case 1:
                setLod1TerrainIntersectionCurve(property);
                return true;
            case 2:
                setLod2TerrainIntersectionCurve(property);
                return true;
            case 3:
                setLod3TerrainIntersectionCurve(property);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (pointCloud != null && pointCloud.getObject() != null)
            envelope.include(pointCloud.getObject().computeEnvelope(options));

        if (adeOfAbstractPhysicalSpace != null) {
            for (ADEOfAbstractPhysicalSpace container : adeOfAbstractPhysicalSpace)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractPhysicalSpace<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
