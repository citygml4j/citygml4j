package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfAuxiliaryTrafficSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAuxiliaryTrafficSpace extends ADEOfAuxiliaryTrafficSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAuxiliaryTrafficSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAuxiliaryTrafficSpace of(Element value) {
        return new GenericADEPropertyOfAuxiliaryTrafficSpace(value);
    }
}
