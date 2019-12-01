package org.citygml4j.model.building;

import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingPart extends AbstractBuilding {
    private List<ADEPropertyOfBuildingPart<?>> adeProperties;

    public List<ADEPropertyOfBuildingPart<?>> getADEPropertiesOfBuildingPart() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBuildingPart(List<ADEPropertyOfBuildingPart<?>> adeProperties) {
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
