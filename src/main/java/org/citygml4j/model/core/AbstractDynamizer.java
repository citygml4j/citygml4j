package org.citygml4j.model.core;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractDynamizer extends AbstractFeatureWithLifespan {
    private List<ADEPropertyOfAbstractDynamizer> adeProperties;

    public List<ADEPropertyOfAbstractDynamizer> getADEPropertiesOfAbstractDynamizer() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractDynamizer(List<ADEPropertyOfAbstractDynamizer> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
