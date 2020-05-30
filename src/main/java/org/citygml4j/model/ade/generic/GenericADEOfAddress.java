package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAddress;
import org.w3c.dom.Element;

public class GenericADEOfAddress extends ADEOfAddress implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAddress() {
    }

    public GenericADEOfAddress(Element value) {
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
