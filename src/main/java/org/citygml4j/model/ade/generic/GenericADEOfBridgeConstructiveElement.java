package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfBridgeConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfBridgeConstructiveElement extends ADEOfBridgeConstructiveElement implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBridgeConstructiveElement() {
    }

    public GenericADEOfBridgeConstructiveElement(Element value) {
        this.value = value;
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
