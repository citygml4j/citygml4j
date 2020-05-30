package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfDoor;
import org.w3c.dom.Element;

public class GenericADEOfDoor extends ADEOfDoor implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfDoor() {
    }

    public GenericADEOfDoor(Element value) {
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
