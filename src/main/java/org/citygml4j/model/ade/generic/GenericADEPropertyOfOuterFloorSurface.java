package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfOuterFloorSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfOuterFloorSurface extends ADEPropertyOfOuterFloorSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfOuterFloorSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfOuterFloorSurface of(Element value) {
        return new GenericADEPropertyOfOuterFloorSurface(value);
    }
}
