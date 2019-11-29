package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractConstructiveElement extends AbstractOccupiedSpace {
    private Boolean isStructuralElement;
    private List<AbstractFillingElementProperty> fillings;
    private List<ADEPropertyOfAbstractConstructiveElement<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public Boolean getIsStructuralElement() {
        return isStructuralElement;
    }

    public boolean isSetIsStructuralElement() {
        return isStructuralElement != null;
    }

    public void setIsStructuralElement(Boolean isStructuralElement) {
        this.isStructuralElement = isStructuralElement;
    }

    public List<AbstractFillingElementProperty> getFillings() {
        if (fillings == null)
            fillings = new ChildList<>(this);

        return fillings;
    }

    public void setFillings(List<AbstractFillingElementProperty> fillings) {
        this.fillings = asChild(fillings);
    }

    public List<ADEPropertyOfAbstractConstructiveElement<?>> getADEPropertiesOfAbstractConstructiveElement() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractConstructiveElement(List<ADEPropertyOfAbstractConstructiveElement<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
