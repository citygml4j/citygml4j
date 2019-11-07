package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractFurniture extends AbstractOccupiedSpace {
    private List<ADEPropertyOfAbstractFurniture> adeProperties;

    @Override
    public boolean isValidBoundarySurface(AbstractThematicSurface boundarySurface) {
        return boundarySurface instanceof ClosureSurface
                || boundarySurface instanceof GenericThematicSurface;
    }

    public List<ADEPropertyOfAbstractFurniture> getADEPropertiesOfAbstractFurniture() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractFurniture(List<ADEPropertyOfAbstractFurniture> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
