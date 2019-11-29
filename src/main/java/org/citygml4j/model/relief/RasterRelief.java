package org.citygml4j.model.relief;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class RasterRelief extends AbstractReliefComponent {
    private GridProperty grid;
    private List<ADEPropertyOfRasterRelief<?>> adeProperties;

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

    public List<ADEPropertyOfRasterRelief<?>> getADEPropertiesOfRasterRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfRasterRelief(List<ADEPropertyOfRasterRelief<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
