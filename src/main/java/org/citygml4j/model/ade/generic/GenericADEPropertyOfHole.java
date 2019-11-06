package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfHole;
import org.w3c.dom.Element;

public class GenericADEPropertyOfHole extends ADEPropertyOfHole<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfHole(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfHole of(Element value) {
        return new GenericADEPropertyOfHole(value);
    }
}
