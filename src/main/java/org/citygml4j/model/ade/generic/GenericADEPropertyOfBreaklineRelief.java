package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfBreaklineRelief;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBreaklineRelief extends ADEOfBreaklineRelief<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBreaklineRelief(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBreaklineRelief of(Element value) {
        return new GenericADEPropertyOfBreaklineRelief(value);
    }
}
