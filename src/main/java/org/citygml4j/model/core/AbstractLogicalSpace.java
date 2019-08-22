package org.citygml4j.model.core;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractLogicalSpace<T extends SpaceBoundaryProperty> extends AbstractSpace<T> {
    private List<ADEPropertyOfAbstractLogicalSpace> adeProperties;

    public List<ADEPropertyOfAbstractLogicalSpace> getADEPropertyOfAbstractLogicalSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfAbstractLogicalSpace(List<ADEPropertyOfAbstractLogicalSpace> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
