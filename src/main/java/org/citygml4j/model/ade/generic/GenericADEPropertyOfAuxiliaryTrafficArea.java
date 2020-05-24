package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfAuxiliaryTrafficArea;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAuxiliaryTrafficArea extends ADEOfAuxiliaryTrafficArea<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAuxiliaryTrafficArea(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAuxiliaryTrafficArea of(Element value) {
        return new GenericADEPropertyOfAuxiliaryTrafficArea(value);
    }
}
