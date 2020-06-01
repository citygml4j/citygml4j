package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfBridgeRoom;
import org.w3c.dom.Element;

public class GenericADEOfBridgeRoom extends ADEOfBridgeRoom implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfBridgeRoom(Element value) {
        this.value = value;
    }

    public static GenericADEOfBridgeRoom of(Element value) {
        return new GenericADEOfBridgeRoom(value);
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
