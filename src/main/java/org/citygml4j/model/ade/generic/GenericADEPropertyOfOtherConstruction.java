package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfOtherConstruction;
import org.w3c.dom.Element;

public class GenericADEPropertyOfOtherConstruction extends ADEOfOtherConstruction<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfOtherConstruction(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfOtherConstruction of(Element value) {
        return new GenericADEPropertyOfOtherConstruction(value);
    }
}
