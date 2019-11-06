package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfSquare;
import org.w3c.dom.Element;

public class GenericADEPropertyOfSquare extends ADEPropertyOfSquare<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfSquare(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfSquare of(Element value) {
        return new GenericADEPropertyOfSquare(value);
    }
}
