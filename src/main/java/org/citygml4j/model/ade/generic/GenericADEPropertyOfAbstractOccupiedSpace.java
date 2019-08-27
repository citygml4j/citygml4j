package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAbstractOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractOccupiedSpace extends ADEPropertyOfAbstractOccupiedSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractOccupiedSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractOccupiedSpace of(Element value) {
        return new GenericADEPropertyOfAbstractOccupiedSpace(value);
    }
}
