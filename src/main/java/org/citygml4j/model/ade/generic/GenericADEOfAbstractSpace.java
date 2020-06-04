package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSpace extends ADEOfAbstractSpace implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractSpace of(Element value) {
        return new GenericADEOfAbstractSpace(value);
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
