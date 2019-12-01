package org.citygml4j.model.building;

import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Building extends AbstractBuilding {
    private List<BuildingPartProperty> buildingParts;
    private List<ADEPropertyOfBuilding<?>> adeProperties;

    public List<BuildingPartProperty> getBuildingParts() {
        if (buildingParts == null)
            buildingParts = new ChildList<>(this);

        return buildingParts;
    }

    public void setBuildingParts(List<BuildingPartProperty> buildingParts) {
        this.buildingParts = asChild(buildingParts);
    }

    public List<ADEPropertyOfBuilding<?>> getADEPropertiesOfBuilding() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBuilding(List<ADEPropertyOfBuilding<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(FeatureVisitor visitor) {
        visitor.visit(this);
    }
}
