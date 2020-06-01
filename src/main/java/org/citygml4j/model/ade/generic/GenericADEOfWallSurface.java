package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWallSurface;
import org.w3c.dom.Element;

public class GenericADEOfWallSurface extends ADEOfWallSurface implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfWallSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfWallSurface of(Element value) {
        return new GenericADEOfWallSurface(value);
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
