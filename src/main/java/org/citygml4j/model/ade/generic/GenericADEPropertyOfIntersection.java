package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfIntersection;
import org.w3c.dom.Element;

public class GenericADEPropertyOfIntersection extends ADEOfIntersection<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfIntersection(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfIntersection of(Element value) {
        return new GenericADEPropertyOfIntersection(value);
    }
}
