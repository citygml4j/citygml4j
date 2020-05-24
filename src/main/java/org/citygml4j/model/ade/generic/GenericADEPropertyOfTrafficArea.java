package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfTrafficArea;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTrafficArea extends ADEOfTrafficArea<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTrafficArea(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTrafficArea of(Element value) {
        return new GenericADEPropertyOfTrafficArea(value);
    }
}
