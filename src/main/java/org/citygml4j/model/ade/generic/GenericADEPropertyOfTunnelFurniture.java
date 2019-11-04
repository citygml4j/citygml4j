package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEPropertyOfTunnelFurniture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTunnelFurniture extends ADEPropertyOfTunnelFurniture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTunnelFurniture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTunnelFurniture of(Element value) {
        return new GenericADEPropertyOfTunnelFurniture(value);
    }
}
