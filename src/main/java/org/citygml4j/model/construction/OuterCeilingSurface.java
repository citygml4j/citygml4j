package org.citygml4j.model.construction;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class OuterCeilingSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfOuterCeilingSurface<?>> adeProperties;

    public List<ADEPropertyOfOuterCeilingSurface<?>> getADEPropertiesOfOuterCeilingSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfOuterCeilingSurface(List<ADEPropertyOfOuterCeilingSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
