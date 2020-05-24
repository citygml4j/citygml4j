package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfAbstractTunnel;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractTunnel extends ADEOfAbstractTunnel<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractTunnel(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractTunnel of(Element value) {
        return new GenericADEPropertyOfAbstractTunnel(value);
    }
}
