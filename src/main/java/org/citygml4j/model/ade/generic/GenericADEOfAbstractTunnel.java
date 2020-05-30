package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfAbstractTunnel;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTunnel extends ADEOfAbstractTunnel implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractTunnel() {
    }

    public GenericADEOfAbstractTunnel(Element value) {
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
