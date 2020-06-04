package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstructiveElement extends ADEOfAbstractConstructiveElement implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractConstructiveElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractConstructiveElement of(Element value) {
        return new GenericADEOfAbstractConstructiveElement(value);
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
