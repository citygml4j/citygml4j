package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class FloorSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfFloorSurface> adeProperties;

    public List<ADEPropertyOfFloorSurface> getADEPropertyOfFloorSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfFloorSurface(List<ADEPropertyOfFloorSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
