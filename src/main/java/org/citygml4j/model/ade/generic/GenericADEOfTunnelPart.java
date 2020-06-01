package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnelPart;
import org.w3c.dom.Element;

public class GenericADEOfTunnelPart extends ADEOfTunnelPart implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfTunnelPart(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnelPart of(Element value) {
        return new GenericADEOfTunnelPart(value);
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
