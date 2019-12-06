package org.citygml4j.model.construction;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class OuterFloorSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfOuterFloorSurface<?>> adeProperties;

    public List<ADEPropertyOfOuterFloorSurface<?>> getADEPropertiesOfOuterFloorSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfOuterFloorSurface(List<ADEPropertyOfOuterFloorSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
