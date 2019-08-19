package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.ClosureSurfaceProperty;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractConstructionSurface extends AbstractThematicSurface {
    private List<AbstractFillingSurfaceProperty> fillingSurfaces;
    private List<ClosureSurfaceProperty> closureSurfaces;
    private List<ADEPropertyOfAbstractConstructionSurface> adeProperties;

    public List<AbstractFillingSurfaceProperty> getFillingSurfaces() {
        if (fillingSurfaces == null)
            fillingSurfaces = new ChildList<>(this);

        return fillingSurfaces;
    }

    public void setFillingSurfaces(List<AbstractFillingSurfaceProperty> fillingSurfaces) {
        this.fillingSurfaces = asChild(fillingSurfaces);
    }

    public List<ClosureSurfaceProperty> getClosureSurfaces() {
        if (closureSurfaces == null)
            closureSurfaces = new ChildList<>(this);

        return closureSurfaces;
    }

    public void setClosureSurfaces(List<ClosureSurfaceProperty> closureSurfaces) {
        this.closureSurfaces = asChild(closureSurfaces);
    }

    public List<ADEPropertyOfAbstractConstructionSurface> getADEPropertyOfAbstractConstructionSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfAbstractConstructionSurface(List<ADEPropertyOfAbstractConstructionSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
