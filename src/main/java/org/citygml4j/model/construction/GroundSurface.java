package org.citygml4j.model.construction;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GroundSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfGroundSurface<?>> adeProperties;

    public List<ADEPropertyOfGroundSurface<?>> getADEPropertiesOfGroundSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfGroundSurface(List<ADEPropertyOfGroundSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
