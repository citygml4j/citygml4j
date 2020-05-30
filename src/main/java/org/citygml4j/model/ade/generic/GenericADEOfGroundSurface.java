package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfGroundSurface;
import org.w3c.dom.Element;

public class GenericADEOfGroundSurface extends ADEOfGroundSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfGroundSurface() {
    }

    public GenericADEOfGroundSurface(Element value) {
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
