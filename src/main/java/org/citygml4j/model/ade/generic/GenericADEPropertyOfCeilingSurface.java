package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfCeilingSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCeilingSurface extends ADEPropertyOfCeilingSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCeilingSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCeilingSurface of(Element value) {
        return new GenericADEPropertyOfCeilingSurface(value);
    }
}
