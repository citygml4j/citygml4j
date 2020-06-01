package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfHoleSurface;
import org.w3c.dom.Element;

public class GenericADEOfHoleSurface extends ADEOfHoleSurface implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfHoleSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfHoleSurface of(Element value) {
        return new GenericADEOfHoleSurface(value);
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
