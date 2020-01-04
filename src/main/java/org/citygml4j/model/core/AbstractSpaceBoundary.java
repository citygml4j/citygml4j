package org.citygml4j.model.core;

import org.citygml4j.util.Envelopes;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractSpaceBoundary extends AbstractCityObject {
    private List<ADEPropertyOfAbstractSpaceBoundary<?>> adeProperties;

    public List<ADEPropertyOfAbstractSpaceBoundary<?>> getADEPropertiesOfAbstractSpaceBoundary() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractSpaceBoundary(List<ADEPropertyOfAbstractSpaceBoundary<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractSpaceBoundary<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
