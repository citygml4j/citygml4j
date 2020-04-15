package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.deprecated.construction.DeprecatedPropertiesOfAbstractFillingSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
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

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractFillingSurface properties = getDeprecatedProperties();

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());

            if (properties.getLod3ImplicitRepresentation() != null && properties.getLod3ImplicitRepresentation().getObject() != null)
                envelope.include(properties.getLod3ImplicitRepresentation().getObject().computeEnvelope());

            if (properties.getLod4ImplicitRepresentation() != null && properties.getLod4ImplicitRepresentation().getObject() != null)
                envelope.include(properties.getLod4ImplicitRepresentation().getObject().computeEnvelope());
        }

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractFillingSurface<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }
}
