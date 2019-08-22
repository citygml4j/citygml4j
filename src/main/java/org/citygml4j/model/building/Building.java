package org.citygml4j.model.building;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class Building extends AbstractBuilding {
    private List<BuildingPartProperty> buildingParts;
    private List<ADEPropertyOfBuilding> adeProperties;

    public List<BuildingPartProperty> getBuildingParts() {
        if (buildingParts == null)
            buildingParts = new ChildList<>(this);

        return buildingParts;
    }

    public void setBuildingParts(List<BuildingPartProperty> buildingParts) {
        this.buildingParts = asChild(buildingParts);
    }

    public List<ADEPropertyOfBuilding> getADEPropertyOfBuilding() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfBuilding(List<ADEPropertyOfBuilding> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
