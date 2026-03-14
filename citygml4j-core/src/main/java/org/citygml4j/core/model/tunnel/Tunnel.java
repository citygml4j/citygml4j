/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.tunnel;

import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Tunnel extends AbstractTunnel implements TopLevelFeature {
    private List<TunnelPartProperty> tunnelParts;

    public List<TunnelPartProperty> getTunnelParts() {
        if (tunnelParts == null)
            tunnelParts = new ChildList<>(this);

        return tunnelParts;
    }

    public boolean isSetTunnelParts() {
        return tunnelParts != null && !tunnelParts.isEmpty();
    }

    public void setTunnelParts(List<TunnelPartProperty> tunnelParts) {
        this.tunnelParts = asChild(tunnelParts);
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
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
