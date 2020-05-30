package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEOfGenericOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEOfGenericOccupiedSpace extends ADEOfGenericOccupiedSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfGenericOccupiedSpace() {
    }

    public GenericADEOfGenericOccupiedSpace(Element value) {
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
