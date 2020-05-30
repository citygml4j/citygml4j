package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfFloorSurface;
import org.w3c.dom.Element;

public class GenericADEOfFloorSurface extends ADEOfFloorSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfFloorSurface() {
    }

    public GenericADEOfFloorSurface(Element value) {
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
