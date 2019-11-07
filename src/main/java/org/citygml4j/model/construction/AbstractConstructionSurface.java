package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractConstructionSurface extends AbstractThematicSurface {
    private List<AbstractFillingSurfaceProperty> fillingSurfaces;
    private List<ADEPropertyOfAbstractConstructionSurface> adeProperties;

    public List<AbstractFillingSurfaceProperty> getFillingSurfaces() {
        if (fillingSurfaces == null)
            fillingSurfaces = new ChildList<>(this);

        return fillingSurfaces;
    }

    public void setFillingSurfaces(List<AbstractFillingSurfaceProperty> fillingSurfaces) {
        this.fillingSurfaces = asChild(fillingSurfaces);
    }

    public List<ADEPropertyOfAbstractConstructionSurface> getADEPropertiesOfAbstractConstructionSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractConstructionSurface(List<ADEPropertyOfAbstractConstructionSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
