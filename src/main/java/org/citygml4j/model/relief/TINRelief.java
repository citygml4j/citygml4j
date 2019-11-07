package org.citygml4j.model.relief;

import org.citygml4j.model.core.AbstractPointCloudProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TINRelief extends AbstractReliefComponent {
    private TinProperty tin;
    private List<ADEPropertyOfTINRelief> adeProperties;

    public TINRelief() {
    }

    public TINRelief(int lod, TinProperty tin) {
        super(lod);
        setTin(tin);
    }

    public TinProperty getTin() {
        return tin;
    }

    public void setTin(TinProperty tin) {
        this.tin = asChild(tin);
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
    public void setPointCloud(AbstractPointCloudProperty pointCloud) {
        // not supported
    }

    @Override
    public boolean setMultiSurface(int lod, MultiSurfaceProperty property) {
        // not supported
        return false;
    }

    public List<ADEPropertyOfTINRelief> getADEPropertiesOfTINRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfTINRelief(List<ADEPropertyOfTINRelief> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
