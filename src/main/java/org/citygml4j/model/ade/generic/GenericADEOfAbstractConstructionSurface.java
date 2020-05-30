package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstructionSurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractConstructionSurface extends ADEOfAbstractConstructionSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractConstructionSurface() {
    }

    public GenericADEOfAbstractConstructionSurface(Element value) {
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
