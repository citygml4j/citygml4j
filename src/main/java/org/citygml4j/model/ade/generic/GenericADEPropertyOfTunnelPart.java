package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEPropertyOfTunnelPart;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTunnelPart extends ADEPropertyOfTunnelPart<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTunnelPart(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTunnelPart of(Element value) {
        return new GenericADEPropertyOfTunnelPart(value);
    }
}
