package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstructiveElement extends ADEOfAbstractConstructiveElement implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractConstructiveElement() {
    }

    public GenericADEOfAbstractConstructiveElement(Element value) {
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
