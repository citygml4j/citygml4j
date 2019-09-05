package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class Window extends AbstractFillingElement {
    private List<ADEPropertyOfWindow> adeProperties;

    @Override
    public boolean isValidBoundarySurface(AbstractThematicSurface boundarySurface) {
        return boundarySurface instanceof WindowSurface
                || boundarySurface instanceof ClosureSurface
                || boundarySurface instanceof GenericThematicSurface;
    }

    public List<ADEPropertyOfWindow> getADEPropertiesOfWindow() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfWindow(List<ADEPropertyOfWindow> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
