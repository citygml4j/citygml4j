package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEPropertyOfTunnelConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTunnelConstructiveElement extends ADEPropertyOfTunnelConstructiveElement<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTunnelConstructiveElement(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTunnelConstructiveElement of(Element value) {
        return new GenericADEPropertyOfTunnelConstructiveElement(value);
    }
}
