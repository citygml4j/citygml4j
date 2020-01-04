package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.util.Envelopes;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractConstructionSurface extends AbstractThematicSurface {
    private List<AbstractFillingSurfaceProperty> fillingSurfaces;
    private List<ADEPropertyOfAbstractConstructionSurface<?>> adeProperties;

    public List<AbstractFillingSurfaceProperty> getFillingSurfaces() {
        if (fillingSurfaces == null)
            fillingSurfaces = new ChildList<>(this);

        return fillingSurfaces;
    }

    public void setFillingSurfaces(List<AbstractFillingSurfaceProperty> fillingSurfaces) {
        this.fillingSurfaces = asChild(fillingSurfaces);
    }

    public List<ADEPropertyOfAbstractConstructionSurface<?>> getADEPropertiesOfAbstractConstructionSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractConstructionSurface(List<ADEPropertyOfAbstractConstructionSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractConstructionSurface<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
