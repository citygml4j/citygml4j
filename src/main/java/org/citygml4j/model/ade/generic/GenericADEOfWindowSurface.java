package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWindowSurface;
import org.w3c.dom.Element;

public class GenericADEOfWindowSurface extends ADEOfWindowSurface implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfWindowSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfWindowSurface of(Element value) {
        return new GenericADEOfWindowSurface(value);
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
