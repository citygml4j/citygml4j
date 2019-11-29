package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.deprecated.construction.DeprecatedPropertiesOfAbstractFillingSurface;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractFillingSurface extends AbstractThematicSurface {
    private List<ADEPropertyOfAbstractFillingSurface<?>> adeProperties;

    @Override
    public DeprecatedPropertiesOfAbstractFillingSurface getDeprecatedProperties() {
        return (DeprecatedPropertiesOfAbstractFillingSurface) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfAbstractFillingSurface createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractFillingSurface();
    }

    public List<ADEPropertyOfAbstractFillingSurface<?>> getADEPropertiesOfAbstractFillingSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractFillingSurface(List<ADEPropertyOfAbstractFillingSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
