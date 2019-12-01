package org.citygml4j.model.construction;

import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class FloorSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfFloorSurface<?>> adeProperties;

    public List<ADEPropertyOfFloorSurface<?>> getADEPropertiesOfFloorSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfFloorSurface(List<ADEPropertyOfFloorSurface<?>> adeProperties) {
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
