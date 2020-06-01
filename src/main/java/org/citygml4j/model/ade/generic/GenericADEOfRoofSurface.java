package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfRoofSurface;
import org.w3c.dom.Element;

public class GenericADEOfRoofSurface extends ADEOfRoofSurface implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfRoofSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfRoofSurface of(Element value) {
        return new GenericADEOfRoofSurface(value);
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
