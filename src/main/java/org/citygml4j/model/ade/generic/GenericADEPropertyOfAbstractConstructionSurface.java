package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstructionSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractConstructionSurface extends ADEOfAbstractConstructionSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractConstructionSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractConstructionSurface of(Element value) {
        return new GenericADEPropertyOfAbstractConstructionSurface(value);
    }
}
