package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfHole;
import org.w3c.dom.Element;

public class GenericADEOfHole extends ADEOfHole implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfHole() {
    }

    public GenericADEOfHole(Element value) {
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
