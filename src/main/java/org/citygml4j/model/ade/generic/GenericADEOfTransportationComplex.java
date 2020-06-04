package org.citygml4j.model.ade.generic;

import org.citygml4j.model.deprecated.transportation.ADEOfTransportationComplex;
import org.w3c.dom.Element;

public class GenericADEOfTransportationComplex extends ADEOfTransportationComplex implements ADEGenericContainer {
    private Element value;

    private GenericADEOfTransportationComplex(Element value) {
        this.value = value;
    }

    public static GenericADEOfTransportationComplex of(Element value) {
        return new GenericADEOfTransportationComplex(value);
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
