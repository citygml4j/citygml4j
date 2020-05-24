package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfBridgeRoom;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBridgeRoom extends ADEOfBridgeRoom<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBridgeRoom(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBridgeRoom of(Element value) {
        return new GenericADEPropertyOfBridgeRoom(value);
    }
}
