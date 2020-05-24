package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfClearanceSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfClearanceSpace extends ADEOfClearanceSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfClearanceSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfClearanceSpace of(Element value) {
        return new GenericADEPropertyOfClearanceSpace(value);
    }
}
