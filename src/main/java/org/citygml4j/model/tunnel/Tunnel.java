package org.citygml4j.model.tunnel;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Tunnel extends AbstractTunnel {
    private List<TunnelPartProperty> tunnelParts;
    private List<ADEOfTunnel> adeOfTunnel;

    public List<TunnelPartProperty> getTunnelParts() {
        if (tunnelParts == null)
            tunnelParts = new ChildList<>(this);

        return tunnelParts;
    }

    public void setTunnelParts(List<TunnelPartProperty> tunnelParts) {
        this.tunnelParts = asChild(tunnelParts);
    }

    public List<ADEOfTunnel> getADEOfTunnel() {
        if (adeOfTunnel == null)
            adeOfTunnel = new ChildList<>(this);

        return adeOfTunnel;
    }

    public void setADEOfTunnel(List<ADEOfTunnel> adeOfTunnel) {
        this.adeOfTunnel = asChild(adeOfTunnel);
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

        if (adeOfTunnel != null) {
            for (ADEOfTunnel container : adeOfTunnel)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfTunnel<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
