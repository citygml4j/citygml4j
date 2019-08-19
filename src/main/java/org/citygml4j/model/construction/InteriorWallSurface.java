package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class InteriorWallSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfInteriorWallSurface> adeProperties;

    public List<ADEPropertyOfInteriorWallSurface> getADEPropertyOfInteriorWallSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfInteriorWallSurface(List<ADEPropertyOfInteriorWallSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
