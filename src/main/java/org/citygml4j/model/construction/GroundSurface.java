package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class GroundSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfGroundSurface> adeProperties;

    public List<ADEPropertyOfGroundSurface> getADEPropertyOfGroundSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfGroundSurface(List<ADEPropertyOfGroundSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
