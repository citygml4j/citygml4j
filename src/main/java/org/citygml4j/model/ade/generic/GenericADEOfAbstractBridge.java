package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfAbstractBridge;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBridge extends ADEOfAbstractBridge implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractBridge(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractBridge of(Element value) {
        return new GenericADEOfAbstractBridge(value);
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
