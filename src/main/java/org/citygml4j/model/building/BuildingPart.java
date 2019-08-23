package org.citygml4j.model.building;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class BuildingPart extends AbstractBuilding {
    private List<ADEPropertyOfBuildingPart> adeProperties;

    public List<ADEPropertyOfBuildingPart> getADEPropertiesOfBuildingPart() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBuildingPart(List<ADEPropertyOfBuildingPart> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
