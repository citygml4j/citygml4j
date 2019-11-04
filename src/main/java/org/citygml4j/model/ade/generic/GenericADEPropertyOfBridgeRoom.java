package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEPropertyOfBridgeRoom;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBridgeRoom extends ADEPropertyOfBridgeRoom<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBridgeRoom(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBridgeRoom of(Element value) {
        return new GenericADEPropertyOfBridgeRoom(value);
    }
}
