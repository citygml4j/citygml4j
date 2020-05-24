package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfFloorSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfFloorSurface extends ADEOfFloorSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfFloorSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfFloorSurface of(Element value) {
        return new GenericADEPropertyOfFloorSurface(value);
    }
}
