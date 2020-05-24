package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEOfGenericThematicSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGenericThematicSurface extends ADEOfGenericThematicSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGenericThematicSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGenericThematicSurface of(Element value) {
        return new GenericADEPropertyOfGenericThematicSurface(value);
    }
}
