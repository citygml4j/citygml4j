package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnelConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfTunnelConstructiveElement extends ADEOfTunnelConstructiveElement implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfTunnelConstructiveElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnelConstructiveElement of(Element value) {
        return new GenericADEOfTunnelConstructiveElement(value);
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
