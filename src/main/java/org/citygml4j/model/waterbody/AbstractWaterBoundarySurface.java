package org.citygml4j.model.waterbody;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.util.Envelopes;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractWaterBoundarySurface extends AbstractThematicSurface {
    private List<ADEPropertyOfAbstractWaterBoundarySurface<?>> adeProperties;

    public List<ADEPropertyOfAbstractWaterBoundarySurface<?>> getADEPropertiesOfAbstractWaterBoundarySurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractWaterBoundarySurface(List<ADEPropertyOfAbstractWaterBoundarySurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractWaterBoundarySurface<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
