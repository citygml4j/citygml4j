package org.citygml4j.model.core;

import org.citygml4j.util.Envelopes;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractUnoccupiedSpace extends AbstractPhysicalSpace {
    private List<ADEPropertyOfAbstractUnoccupiedSpace<?>> adeProperties;

    public List<ADEPropertyOfAbstractUnoccupiedSpace<?>> getADEPropertiesOfAbstractUnoccupiedSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractUnoccupiedSpace(List<ADEPropertyOfAbstractUnoccupiedSpace<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractUnoccupiedSpace<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
