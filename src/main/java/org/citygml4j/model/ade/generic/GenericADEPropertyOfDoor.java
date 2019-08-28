package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfDoor;
import org.w3c.dom.Element;

public class GenericADEPropertyOfDoor extends ADEPropertyOfDoor<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfDoor(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfDoor of(Element value) {
        return new GenericADEPropertyOfDoor(value);
    }
}
