package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfTrafficArea;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTrafficArea extends ADEPropertyOfTrafficArea<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTrafficArea(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTrafficArea of(Element value) {
        return new GenericADEPropertyOfTrafficArea(value);
    }
}
