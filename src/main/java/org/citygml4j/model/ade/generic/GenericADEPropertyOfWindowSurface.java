package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWindowSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWindowSurface extends ADEOfWindowSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWindowSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWindowSurface of(Element value) {
        return new GenericADEPropertyOfWindowSurface(value);
    }
}
