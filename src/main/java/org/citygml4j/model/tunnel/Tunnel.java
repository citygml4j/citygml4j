package org.citygml4j.model.tunnel;

import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Tunnel extends AbstractTunnel {
    private List<TunnelPartProperty> tunnelParts;
    private List<ADEPropertyOfTunnel<?>> adeProperties;

    public List<TunnelPartProperty> getTunnelParts() {
        if (tunnelParts == null)
            tunnelParts = new ChildList<>(this);

        return tunnelParts;
    }

    public void setTunnelParts(List<TunnelPartProperty> tunnelParts) {
        this.tunnelParts = asChild(tunnelParts);
    }

    public List<ADEPropertyOfTunnel<?>> getADEPropertiesOfTunnel() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfTunnel(List<ADEPropertyOfTunnel<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (tunnelParts != null) {
            for (TunnelPartProperty property : tunnelParts) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (adeProperties != null) {
            for (ADEPropertyOfTunnel<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
