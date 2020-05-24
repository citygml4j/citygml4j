package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfTINRelief;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTINRelief extends ADEOfTINRelief<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTINRelief(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTINRelief of(Element value) {
        return new GenericADEPropertyOfTINRelief(value);
    }
}
