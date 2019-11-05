package org.citygml4j.model.relief;

import org.citygml4j.model.core.AbstractPointCloudProperty;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

import java.util.List;

public class RasterRelief extends AbstractReliefComponent {
    private GridProperty grid;
    private List<ADEPropertyOfRasterRelief> adeProperties;

    public RasterRelief() {
    }

    public RasterRelief(int lod, GridProperty grid) {
        super(lod);
        setGrid(grid);
    }

    public GridProperty getGrid() {
        return grid;
    }

    public void setGrid(GridProperty grid) {
        this.grid = asChild(grid);
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

    public List<ADEPropertyOfRasterRelief> getADEPropertiesOfRasterRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfRasterRelief(List<ADEPropertyOfRasterRelief> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
