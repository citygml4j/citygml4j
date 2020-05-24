package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfOuterCeilingSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfOuterCeilingSurface extends ADEOfOuterCeilingSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfOuterCeilingSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfOuterCeilingSurface of(Element value) {
        return new GenericADEPropertyOfOuterCeilingSurface(value);
    }
}
