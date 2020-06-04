package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfOuterFloorSurface;
import org.w3c.dom.Element;

public class GenericADEOfOuterFloorSurface extends ADEOfOuterFloorSurface implements ADEGenericContainer {
    private Element value;

    private GenericADEOfOuterFloorSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfOuterFloorSurface of(Element value) {
        return new GenericADEOfOuterFloorSurface(value);
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
