package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEOfGenericOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGenericOccupiedSpace extends ADEOfGenericOccupiedSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGenericOccupiedSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGenericOccupiedSpace of(Element value) {
        return new GenericADEPropertyOfGenericOccupiedSpace(value);
    }
}
