package org.citygml4j.model.ade.generic;

import org.citygml4j.model.deprecated.transportation.ADEOfTransportationComplex;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTransportationComplex extends ADEOfTransportationComplex<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTransportationComplex(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTransportationComplex of(Element value) {
        return new GenericADEPropertyOfTransportationComplex(value);
    }
}
