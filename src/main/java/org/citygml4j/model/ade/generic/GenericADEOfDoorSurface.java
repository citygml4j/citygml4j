package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfDoorSurface;
import org.w3c.dom.Element;

public class GenericADEOfDoorSurface extends ADEOfDoorSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfDoorSurface() {
    }

    public GenericADEOfDoorSurface(Element value) {
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
