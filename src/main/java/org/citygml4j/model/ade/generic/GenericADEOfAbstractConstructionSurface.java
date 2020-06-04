package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstructionSurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstructionSurface extends ADEOfAbstractConstructionSurface implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractConstructionSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractConstructionSurface of(Element value) {
        return new GenericADEOfAbstractConstructionSurface(value);
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
