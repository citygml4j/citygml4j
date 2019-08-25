package org.citygml4j.model.core;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractUnoccupiedSpace extends AbstractSpace {
    private List<ADEPropertyOfAbstractUnoccupiedSpace> adeProperties;

    public List<ADEPropertyOfAbstractUnoccupiedSpace> getADEPropertiesOfAbstractUnoccupiedSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractUnoccupiedSpace(List<ADEPropertyOfAbstractUnoccupiedSpace> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
