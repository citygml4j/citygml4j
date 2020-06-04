package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfGroundSurface;
import org.w3c.dom.Element;

public class GenericADEOfGroundSurface extends ADEOfGroundSurface implements ADEGenericContainer {
    private Element value;

    private GenericADEOfGroundSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfGroundSurface of(Element value) {
        return new GenericADEOfGroundSurface(value);
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
