package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfBridge;
import org.w3c.dom.Element;

public class GenericADEOfBridge extends ADEOfBridge implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBridge() {
    }

    public GenericADEOfBridge(Element value) {
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
