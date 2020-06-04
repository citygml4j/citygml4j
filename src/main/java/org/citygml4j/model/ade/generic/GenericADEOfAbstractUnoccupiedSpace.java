package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractUnoccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractUnoccupiedSpace extends ADEOfAbstractUnoccupiedSpace implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractUnoccupiedSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractUnoccupiedSpace of(Element value) {
        return new GenericADEOfAbstractUnoccupiedSpace(value);
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
