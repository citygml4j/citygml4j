package org.citygml4j.model.construction;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class CeilingSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfCeilingSurface<?>> adeProperties;

    public List<ADEPropertyOfCeilingSurface<?>> getADEPropertiesOfCeilingSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfCeilingSurface(List<ADEPropertyOfCeilingSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
