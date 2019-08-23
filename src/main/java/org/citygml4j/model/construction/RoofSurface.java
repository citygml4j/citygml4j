package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class RoofSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfRoofSurface> adeProperties;

    public List<ADEPropertyOfRoofSurface> getADEPropertiesOfRoofSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfRoofSurface(List<ADEPropertyOfRoofSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
