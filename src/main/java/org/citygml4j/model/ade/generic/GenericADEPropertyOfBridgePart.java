package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEPropertyOfBridgePart;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBridgePart extends ADEPropertyOfBridgePart<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBridgePart(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBridgePart of(Element value) {
        return new GenericADEPropertyOfBridgePart(value);
    }
}
