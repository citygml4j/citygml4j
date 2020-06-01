package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractOccupiedSpace extends ADEOfAbstractOccupiedSpace implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractOccupiedSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractOccupiedSpace of(Element value) {
        return new GenericADEOfAbstractOccupiedSpace(value);
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
