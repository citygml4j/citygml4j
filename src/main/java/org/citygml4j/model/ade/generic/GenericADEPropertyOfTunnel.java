package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfTunnel;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTunnel extends ADEOfTunnel<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTunnel(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTunnel of(Element value) {
        return new GenericADEPropertyOfTunnel(value);
    }
}
