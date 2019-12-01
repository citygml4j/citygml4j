package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class HoleSurface extends AbstractThematicSurface {
    private List<ADEPropertyOfHoleSurface<?>> adeProperties;

    public List<ADEPropertyOfHoleSurface<?>> getADEPropertiesOfHoleSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfHoleSurface(List<ADEPropertyOfHoleSurface<?>> adeProperties) {
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
