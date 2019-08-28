package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfAbstractConstructionSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractConstructionSurface extends ADEPropertyOfAbstractConstructionSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractConstructionSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractConstructionSurface of(Element value) {
        return new GenericADEPropertyOfAbstractConstructionSurface(value);
    }
}
