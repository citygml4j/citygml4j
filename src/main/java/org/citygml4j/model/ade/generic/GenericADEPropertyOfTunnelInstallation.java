package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnelInstallation;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTunnelInstallation extends ADEOfTunnelInstallation<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTunnelInstallation(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTunnelInstallation of(Element value) {
        return new GenericADEPropertyOfTunnelInstallation(value);
    }
}
