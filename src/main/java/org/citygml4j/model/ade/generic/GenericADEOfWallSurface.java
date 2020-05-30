package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWallSurface;
import org.w3c.dom.Element;

public class GenericADEOfWallSurface extends ADEOfWallSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfWallSurface() {
    }

    public GenericADEOfWallSurface(Element value) {
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
