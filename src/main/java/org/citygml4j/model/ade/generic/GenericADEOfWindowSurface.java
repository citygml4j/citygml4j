package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWindowSurface;
import org.w3c.dom.Element;

public class GenericADEOfWindowSurface extends ADEOfWindowSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfWindowSurface() {
    }

    public GenericADEOfWindowSurface(Element value) {
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
