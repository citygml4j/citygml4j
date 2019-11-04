package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEPropertyOfTunnelInstallation;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTunnelInstallation extends ADEPropertyOfTunnelInstallation<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTunnelInstallation(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTunnelInstallation of(Element value) {
        return new GenericADEPropertyOfTunnelInstallation(value);
    }
}
