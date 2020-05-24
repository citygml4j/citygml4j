package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfDoorSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfDoorSurface extends ADEOfDoorSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfDoorSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfDoorSurface of(Element value) {
        return new GenericADEPropertyOfDoorSurface(value);
    }
}
