package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfDoor;
import org.w3c.dom.Element;

public class GenericADEPropertyOfDoor extends ADEOfDoor<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfDoor(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfDoor of(Element value) {
        return new GenericADEPropertyOfDoor(value);
    }
}
