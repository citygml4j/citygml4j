package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfBridgeFurniture;
import org.w3c.dom.Element;

public class GenericADEOfBridgeFurniture extends ADEOfBridgeFurniture implements ADEGenericContainer {
    private Element value;

    private GenericADEOfBridgeFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfBridgeFurniture of(Element value) {
        return new GenericADEOfBridgeFurniture(value);
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
