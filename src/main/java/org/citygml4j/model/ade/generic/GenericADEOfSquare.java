package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfSquare;
import org.w3c.dom.Element;

public class GenericADEOfSquare extends ADEOfSquare implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfSquare() {
    }

    public GenericADEOfSquare(Element value) {
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
