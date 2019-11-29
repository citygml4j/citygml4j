package org.citygml4j.model.vegetation;

import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractVegetationObject extends AbstractOccupiedSpace {
    private List<ADEPropertyOfAbstractVegetationObject<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public List<ADEPropertyOfAbstractVegetationObject<?>> getADEPropertiesOfAbstractVegetationObject() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractVegetationObject(List<ADEPropertyOfAbstractVegetationObject<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
