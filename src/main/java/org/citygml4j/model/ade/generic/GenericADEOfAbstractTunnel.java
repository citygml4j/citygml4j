package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfAbstractTunnel;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTunnel extends ADEOfAbstractTunnel implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractTunnel(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractTunnel of(Element value) {
        return new GenericADEOfAbstractTunnel(value);
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
