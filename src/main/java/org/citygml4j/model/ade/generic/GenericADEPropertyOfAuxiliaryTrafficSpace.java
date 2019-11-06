package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfAuxiliaryTrafficSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAuxiliaryTrafficSpace extends ADEPropertyOfAuxiliaryTrafficSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAuxiliaryTrafficSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAuxiliaryTrafficSpace of(Element value) {
        return new GenericADEPropertyOfAuxiliaryTrafficSpace(value);
    }
}
