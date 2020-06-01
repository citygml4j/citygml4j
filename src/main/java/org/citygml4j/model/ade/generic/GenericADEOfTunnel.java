package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnel;
import org.w3c.dom.Element;

public class GenericADEOfTunnel extends ADEOfTunnel implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfTunnel(Element value) {
        this.value = value;
    }

    public static GenericADEOfTunnel of(Element value) {
        return new GenericADEOfTunnel(value);
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
