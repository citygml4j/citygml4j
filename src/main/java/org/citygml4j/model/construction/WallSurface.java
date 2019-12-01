package org.citygml4j.model.construction;

import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class WallSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfWallSurface<?>> adeProperties;

    public List<ADEPropertyOfWallSurface<?>> getADEPropertiesOfWallSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfWallSurface(List<ADEPropertyOfWallSurface<?>> adeProperties) {
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
