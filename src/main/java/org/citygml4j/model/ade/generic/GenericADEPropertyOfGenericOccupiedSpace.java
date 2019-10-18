package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEPropertyOfGenericOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGenericOccupiedSpace extends ADEPropertyOfGenericOccupiedSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGenericOccupiedSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGenericOccupiedSpace of(Element value) {
        return new GenericADEPropertyOfGenericOccupiedSpace(value);
    }
}
