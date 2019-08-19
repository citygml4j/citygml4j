package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class WallSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfWallSurface> adeProperties;

    public List<ADEPropertyOfWallSurface> getADEPropertyOfWallSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfWallSurface(List<ADEPropertyOfWallSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
