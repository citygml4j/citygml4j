package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfIntersection;
import org.w3c.dom.Element;

public class GenericADEPropertyOfIntersection extends ADEPropertyOfIntersection<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfIntersection(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfIntersection of(Element value) {
        return new GenericADEPropertyOfIntersection(value);
    }
}
