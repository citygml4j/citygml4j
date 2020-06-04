package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfIntersection;
import org.w3c.dom.Element;

public class GenericADEOfIntersection extends ADEOfIntersection implements ADEGenericContainer {
    private Element value;

    private GenericADEOfIntersection(Element value) {
        this.value = value;
    }

    public static GenericADEOfIntersection of(Element value) {
        return new GenericADEOfIntersection(value);
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
