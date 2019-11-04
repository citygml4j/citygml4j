package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEPropertyOfAbstractTunnel;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractTunnel extends ADEPropertyOfAbstractTunnel<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractTunnel(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractTunnel of(Element value) {
        return new GenericADEPropertyOfAbstractTunnel(value);
    }
}
