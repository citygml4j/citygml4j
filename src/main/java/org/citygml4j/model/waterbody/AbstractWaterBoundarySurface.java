package org.citygml4j.model.waterbody;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractWaterBoundarySurface extends AbstractThematicSurface {
    private List<ADEPropertyOfAbstractWaterBoundarySurface> adeProperties;

    public List<ADEPropertyOfAbstractWaterBoundarySurface> getADEPropertiesOfAbstractWaterBoundarySurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractWaterBoundarySurface(List<ADEPropertyOfAbstractWaterBoundarySurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
