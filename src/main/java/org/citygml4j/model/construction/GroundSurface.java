package org.citygml4j.model.construction;

import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GroundSurface extends AbstractConstructionSurface {
    private List<ADEPropertyOfGroundSurface<?>> adeProperties;

    public List<ADEPropertyOfGroundSurface<?>> getADEPropertiesOfGroundSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfGroundSurface(List<ADEPropertyOfGroundSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfGroundSurface<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
