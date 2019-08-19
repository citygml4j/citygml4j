package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractFillingSurface extends AbstractThematicSurface {
    private List<ADEPropertyOfAbstractFillingSurface> adeProperties;

    public List<ADEPropertyOfAbstractFillingSurface> getADEPropertyOfAbstractFillingSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfAbstractFillingSurface(List<ADEPropertyOfAbstractFillingSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
