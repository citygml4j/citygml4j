package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractSpaceBoundary;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSpaceBoundary extends ADEOfAbstractSpaceBoundary implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractSpaceBoundary(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractSpaceBoundary of(Element value) {
        return new GenericADEOfAbstractSpaceBoundary(value);
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
