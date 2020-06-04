package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfAuxiliaryTrafficSpace;
import org.w3c.dom.Element;

public class GenericADEOfAuxiliaryTrafficSpace extends ADEOfAuxiliaryTrafficSpace implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAuxiliaryTrafficSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAuxiliaryTrafficSpace of(Element value) {
        return new GenericADEOfAuxiliaryTrafficSpace(value);
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
