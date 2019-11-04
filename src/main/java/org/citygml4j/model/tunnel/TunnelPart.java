package org.citygml4j.model.tunnel;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class TunnelPart extends AbstractTunnel {
    private List<ADEPropertyOfTunnelPart> adeProperties;

    public List<ADEPropertyOfTunnelPart> getADEPropertiesOfTunnelPart() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfTunnelPart(List<ADEPropertyOfTunnelPart> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
