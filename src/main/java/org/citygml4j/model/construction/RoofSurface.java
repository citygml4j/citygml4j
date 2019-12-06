package org.citygml4j.model.construction;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class RoofSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfRoofSurface<?>> adeProperties;

    public List<ADEPropertyOfRoofSurface<?>> getADEPropertiesOfRoofSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfRoofSurface(List<ADEPropertyOfRoofSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
