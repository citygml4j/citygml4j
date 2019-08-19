package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class OuterFloorSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfOuterFloorSurface> adeProperties;

    public List<ADEPropertyOfOuterFloorSurface> getADEPropertyOfOuterFloorSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfOuterFloorSurface(List<ADEPropertyOfOuterFloorSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
