package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractThematicSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractThematicSurface extends ADEOfAbstractThematicSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractThematicSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractThematicSurface of(Element value) {
        return new GenericADEPropertyOfAbstractThematicSurface(value);
    }
}
