package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfInteriorWallSurface;
import org.w3c.dom.Element;

public class GenericADEOfInteriorWallSurface extends ADEOfInteriorWallSurface implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfInteriorWallSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfInteriorWallSurface of(Element value) {
        return new GenericADEOfInteriorWallSurface(value);
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
