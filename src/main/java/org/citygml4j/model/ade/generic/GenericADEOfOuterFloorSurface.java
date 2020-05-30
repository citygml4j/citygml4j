package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfOuterFloorSurface;
import org.w3c.dom.Element;

public class GenericADEOfOuterFloorSurface extends ADEOfOuterFloorSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfOuterFloorSurface() {
    }

    public GenericADEOfOuterFloorSurface(Element value) {
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
