package org.citygml4j.model.construction;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class InteriorWallSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfInteriorWallSurface> adeProperties;

    public List<ADEPropertyOfInteriorWallSurface> getADEPropertiesOfInteriorWallSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfInteriorWallSurface(List<ADEPropertyOfInteriorWallSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
