package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfRoofSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfRoofSurface extends ADEPropertyOfRoofSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfRoofSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfRoofSurface of(Element value) {
        return new GenericADEPropertyOfRoofSurface(value);
    }
}
