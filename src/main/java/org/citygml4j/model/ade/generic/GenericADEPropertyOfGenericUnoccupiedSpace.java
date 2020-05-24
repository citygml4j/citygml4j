package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEOfGenericUnoccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGenericUnoccupiedSpace extends ADEOfGenericUnoccupiedSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGenericUnoccupiedSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGenericUnoccupiedSpace of(Element value) {
        return new GenericADEPropertyOfGenericUnoccupiedSpace(value);
    }
}
