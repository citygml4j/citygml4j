package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractSpaceBoundary;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSpaceBoundary extends ADEOfAbstractSpaceBoundary implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractSpaceBoundary() {
    }

    public GenericADEOfAbstractSpaceBoundary(Element value) {
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
