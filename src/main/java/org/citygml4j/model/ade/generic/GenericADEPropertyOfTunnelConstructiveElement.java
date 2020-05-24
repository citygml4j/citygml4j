package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnelConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTunnelConstructiveElement extends ADEOfTunnelConstructiveElement<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTunnelConstructiveElement(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTunnelConstructiveElement of(Element value) {
        return new GenericADEPropertyOfTunnelConstructiveElement(value);
    }
}
