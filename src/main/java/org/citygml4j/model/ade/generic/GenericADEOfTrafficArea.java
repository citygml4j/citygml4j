package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfTrafficArea;
import org.w3c.dom.Element;

public class GenericADEOfTrafficArea extends ADEOfTrafficArea implements ADEGenericContainer {
    private Element value;

    private GenericADEOfTrafficArea(Element value) {
        this.value = value;
    }

    public static GenericADEOfTrafficArea of(Element value) {
        return new GenericADEOfTrafficArea(value);
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
