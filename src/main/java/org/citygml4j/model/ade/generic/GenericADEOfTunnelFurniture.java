package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnelFurniture;
import org.w3c.dom.Element;

public class GenericADEOfTunnelFurniture extends ADEOfTunnelFurniture implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfTunnelFurniture() {
    }

    public GenericADEOfTunnelFurniture(Element value) {
        this.value = value;
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
