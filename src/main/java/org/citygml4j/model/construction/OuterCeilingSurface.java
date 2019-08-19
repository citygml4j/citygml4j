package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class OuterCeilingSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfOuterCeilingSurface> adeProperties;

    public List<ADEPropertyOfOuterCeilingSurface> getADEPropertyOfOuterCeilingSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfOuterCeilingSurface(List<ADEPropertyOfOuterCeilingSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
