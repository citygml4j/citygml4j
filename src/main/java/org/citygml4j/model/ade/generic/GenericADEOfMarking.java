package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfMarking;
import org.w3c.dom.Element;

public class GenericADEOfMarking extends ADEOfMarking implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfMarking() {
    }

    public GenericADEOfMarking(Element value) {
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
