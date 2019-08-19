package org.citygml4j.model.core;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class ClosureSurface extends AbstractThematicSurface {
    private List<ADEPropertyOfClosureSurface> adeProperties;

    public List<ADEPropertyOfClosureSurface> getADEPropertyOfClosureSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfClosureSurface(List<ADEPropertyOfClosureSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
