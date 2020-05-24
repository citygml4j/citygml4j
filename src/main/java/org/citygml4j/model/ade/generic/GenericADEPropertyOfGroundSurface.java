package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfGroundSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGroundSurface extends ADEOfGroundSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGroundSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGroundSurface of(Element value) {
        return new GenericADEPropertyOfGroundSurface(value);
    }
}
