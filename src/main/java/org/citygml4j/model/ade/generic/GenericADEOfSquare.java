package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfSquare;
import org.w3c.dom.Element;

public class GenericADEOfSquare extends ADEOfSquare implements ADEGenericContainer {
    private Element value;

    private GenericADEOfSquare(Element value) {
        this.value = value;
    }

    public static GenericADEOfSquare of(Element value) {
        return new GenericADEOfSquare(value);
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
