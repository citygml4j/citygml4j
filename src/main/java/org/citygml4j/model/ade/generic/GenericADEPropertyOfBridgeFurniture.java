package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEPropertyOfBridgeFurniture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBridgeFurniture extends ADEPropertyOfBridgeFurniture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBridgeFurniture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBridgeFurniture of(Element value) {
        return new GenericADEPropertyOfBridgeFurniture(value);
    }
}
