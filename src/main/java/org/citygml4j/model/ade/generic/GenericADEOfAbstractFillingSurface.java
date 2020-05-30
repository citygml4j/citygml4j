package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractFillingSurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFillingSurface extends ADEOfAbstractFillingSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractFillingSurface() {
    }

    public GenericADEOfAbstractFillingSurface(Element value) {
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
