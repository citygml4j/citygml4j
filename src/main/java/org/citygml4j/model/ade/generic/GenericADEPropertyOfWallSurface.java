package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfWallSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWallSurface extends ADEPropertyOfWallSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWallSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWallSurface of(Element value) {
        return new GenericADEPropertyOfWallSurface(value);
    }
}
