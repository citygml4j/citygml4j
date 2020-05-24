package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfHoleSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfHoleSurface extends ADEOfHoleSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfHoleSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfHoleSurface of(Element value) {
        return new GenericADEPropertyOfHoleSurface(value);
    }
}
