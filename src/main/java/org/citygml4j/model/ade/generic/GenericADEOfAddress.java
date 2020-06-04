package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAddress;
import org.w3c.dom.Element;

public class GenericADEOfAddress extends ADEOfAddress implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAddress(Element value) {
        this.value = value;
    }

    public static GenericADEOfAddress of(Element value) {
        return new GenericADEOfAddress(value);
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
