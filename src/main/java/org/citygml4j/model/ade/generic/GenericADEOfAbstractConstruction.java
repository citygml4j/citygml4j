package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstruction;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstruction extends ADEOfAbstractConstruction implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractConstruction() {
    }

    public GenericADEOfAbstractConstruction(Element value) {
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
