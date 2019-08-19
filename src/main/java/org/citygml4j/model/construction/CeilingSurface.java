package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class CeilingSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfCeilingSurface> adeProperties;

    public List<ADEPropertyOfCeilingSurface> getADEPropertyOfCeilingSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfCeilingSurface(List<ADEPropertyOfCeilingSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
