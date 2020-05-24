package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfCeilingSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCeilingSurface extends ADEOfCeilingSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCeilingSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCeilingSurface of(Element value) {
        return new GenericADEPropertyOfCeilingSurface(value);
    }
}
