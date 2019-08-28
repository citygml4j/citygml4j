package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfOtherConstruction;
import org.w3c.dom.Element;

public class GenericADEPropertyOfOtherConstruction extends ADEPropertyOfOtherConstruction<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfOtherConstruction(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfOtherConstruction of(Element value) {
        return new GenericADEPropertyOfOtherConstruction(value);
    }
}
