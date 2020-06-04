package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfDoor;
import org.w3c.dom.Element;

public class GenericADEOfDoor extends ADEOfDoor implements ADEGenericContainer {
    private Element value;

    private GenericADEOfDoor(Element value) {
        this.value = value;
    }

    public static GenericADEOfDoor of(Element value) {
        return new GenericADEOfDoor(value);
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
