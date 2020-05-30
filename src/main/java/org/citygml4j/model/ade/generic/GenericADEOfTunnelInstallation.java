package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnelInstallation;
import org.w3c.dom.Element;

public class GenericADEOfTunnelInstallation extends ADEOfTunnelInstallation implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfTunnelInstallation() {
    }

    public GenericADEOfTunnelInstallation(Element value) {
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
