package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWallSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWallSurface extends ADEOfWallSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWallSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWallSurface of(Element value) {
        return new GenericADEPropertyOfWallSurface(value);
    }
}
