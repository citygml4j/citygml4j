package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfIntersection;
import org.w3c.dom.Element;

public class GenericADEOfIntersection extends ADEOfIntersection implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfIntersection() {
    }

    public GenericADEOfIntersection(Element value) {
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
