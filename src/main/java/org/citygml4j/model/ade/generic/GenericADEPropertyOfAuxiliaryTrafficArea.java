package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfAuxiliaryTrafficArea;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAuxiliaryTrafficArea extends ADEPropertyOfAuxiliaryTrafficArea<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAuxiliaryTrafficArea(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAuxiliaryTrafficArea of(Element value) {
        return new GenericADEPropertyOfAuxiliaryTrafficArea(value);
    }
}
