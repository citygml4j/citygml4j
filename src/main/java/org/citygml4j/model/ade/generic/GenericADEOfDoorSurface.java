package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfDoorSurface;
import org.w3c.dom.Element;

public class GenericADEOfDoorSurface extends ADEOfDoorSurface implements ADEGenericContainer {
    private Element value;

    private GenericADEOfDoorSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfDoorSurface of(Element value) {
        return new GenericADEOfDoorSurface(value);
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
