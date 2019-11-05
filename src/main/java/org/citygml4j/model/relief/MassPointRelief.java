package org.citygml4j.model.relief;

import org.citygml4j.model.core.AbstractPointCloudProperty;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

import java.util.List;

public class MassPointRelief extends AbstractReliefComponent {
    private List<ADEPropertyOfMassPointRelief> adeProperties;

    public MassPointRelief() {
    }

    public MassPointRelief(int lod, AbstractPointCloudProperty pointCloud) {
        super(lod);
        setPointCloud(pointCloud);
    }

    @Override
    public void setLod0MultiCurve(MultiCurveProperty lod0MultiCurve) {
        // not supported
    }

    @Override
    public void setLod0MultiSurface(MultiSurfaceProperty lod0MultiSurface) {
        // not supported
    }

    @Override
    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        // not supported
    }

    @Override
    public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
        // not supported
    }

    @Override
    public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
        // not supported
    }

    @Override
    public boolean setMultiSurface(int lod, MultiSurfaceProperty property) {
        // not supported
        return false;
    }

    public List<ADEPropertyOfMassPointRelief> getADEPropertiesOfMassPointRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfMassPointRelief(List<ADEPropertyOfMassPointRelief> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
