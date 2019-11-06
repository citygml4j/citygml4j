package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfMarking;
import org.w3c.dom.Element;

public class GenericADEPropertyOfMarking extends ADEPropertyOfMarking<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfMarking(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfMarking of(Element value) {
        return new GenericADEPropertyOfMarking(value);
    }
}
