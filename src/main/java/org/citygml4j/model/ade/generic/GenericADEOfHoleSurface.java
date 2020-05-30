package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfHoleSurface;
import org.w3c.dom.Element;

public class GenericADEOfHoleSurface extends ADEOfHoleSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfHoleSurface() {
    }

    public GenericADEOfHoleSurface(Element value) {
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
