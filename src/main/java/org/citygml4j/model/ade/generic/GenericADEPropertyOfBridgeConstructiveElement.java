package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEPropertyOfBridgeConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBridgeConstructiveElement extends ADEPropertyOfBridgeConstructiveElement<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBridgeConstructiveElement(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBridgeConstructiveElement of(Element value) {
        return new GenericADEPropertyOfBridgeConstructiveElement(value);
    }
}
