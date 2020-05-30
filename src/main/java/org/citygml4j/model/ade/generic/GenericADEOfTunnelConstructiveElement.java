package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnelConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfTunnelConstructiveElement extends ADEOfTunnelConstructiveElement implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfTunnelConstructiveElement() {
    }

    public GenericADEOfTunnelConstructiveElement(Element value) {
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
