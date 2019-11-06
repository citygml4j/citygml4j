package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfAbstractTransportationSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractTransportationSpace extends ADEPropertyOfAbstractTransportationSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractTransportationSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractTransportationSpace of(Element value) {
        return new GenericADEPropertyOfAbstractTransportationSpace(value);
    }
}
