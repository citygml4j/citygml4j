package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfCeilingSurface;
import org.w3c.dom.Element;

public class GenericADEOfCeilingSurface extends ADEOfCeilingSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfCeilingSurface() {
    }

    public GenericADEOfCeilingSurface(Element value) {
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
