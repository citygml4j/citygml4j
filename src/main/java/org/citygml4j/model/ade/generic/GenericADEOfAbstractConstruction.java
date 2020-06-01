package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstruction;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstruction extends ADEOfAbstractConstruction implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractConstruction(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractConstruction of(Element value) {
        return new GenericADEOfAbstractConstruction(value);
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
