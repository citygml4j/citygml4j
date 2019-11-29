package org.citygml4j.model.core;

import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractSpaceBoundary extends AbstractCityObject {
    private List<ADEPropertyOfAbstractSpaceBoundary<?>> adeProperties;

    public List<ADEPropertyOfAbstractSpaceBoundary<?>> getADEPropertiesOfAbstractSpaceBoundary() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractSpaceBoundary(List<ADEPropertyOfAbstractSpaceBoundary<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
