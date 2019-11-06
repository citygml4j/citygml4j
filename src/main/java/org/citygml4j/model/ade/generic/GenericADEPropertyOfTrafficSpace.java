package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfTrafficSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTrafficSpace extends ADEPropertyOfTrafficSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTrafficSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTrafficSpace of(Element value) {
        return new GenericADEPropertyOfTrafficSpace(value);
    }
}
