package org.citygml4j.model.tunnel;

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
}
