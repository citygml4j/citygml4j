package org.citygml4j.model.core;

import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractAppearance extends AbstractFeatureWithLifespan {
    private List<ADEPropertyOfAbstractAppearance> adeProperties;

    public List<ADEPropertyOfAbstractAppearance> getADEPropertiesOfAbstractAppearance() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractAppearance(List<ADEPropertyOfAbstractAppearance> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
