package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfAbstractBridge;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBridge extends ADEOfAbstractBridge implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractBridge() {
    }

    public GenericADEOfAbstractBridge(Element value) {
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
