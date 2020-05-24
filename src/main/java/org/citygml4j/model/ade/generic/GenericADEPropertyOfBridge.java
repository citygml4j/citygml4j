package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfBridge;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBridge extends ADEOfBridge<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBridge(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBridge of(Element value) {
        return new GenericADEPropertyOfBridge(value);
    }
}
