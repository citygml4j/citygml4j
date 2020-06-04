package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfCeilingSurface;
import org.w3c.dom.Element;

public class GenericADEOfCeilingSurface extends ADEOfCeilingSurface implements ADEGenericContainer {
    private Element value;

    private GenericADEOfCeilingSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfCeilingSurface of(Element value) {
        return new GenericADEOfCeilingSurface(value);
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
