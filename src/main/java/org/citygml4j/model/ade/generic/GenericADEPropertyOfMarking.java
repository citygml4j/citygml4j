package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfMarking;
import org.w3c.dom.Element;

public class GenericADEPropertyOfMarking extends ADEOfMarking<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfMarking(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfMarking of(Element value) {
        return new GenericADEPropertyOfMarking(value);
    }
}
