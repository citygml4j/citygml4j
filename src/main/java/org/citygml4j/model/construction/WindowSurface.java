package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class WindowSurface extends AbstractFillingSurface {
    private List<ADEPropertyOfWindowSurface> adeProperties;

    public List<ADEPropertyOfWindowSurface> getADEPropertyOfWindowSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfWindowSurface(List<ADEPropertyOfWindowSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
