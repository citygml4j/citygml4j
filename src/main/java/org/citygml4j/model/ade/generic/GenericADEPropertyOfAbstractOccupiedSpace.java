package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractOccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractOccupiedSpace extends ADEOfAbstractOccupiedSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractOccupiedSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractOccupiedSpace of(Element value) {
        return new GenericADEPropertyOfAbstractOccupiedSpace(value);
    }
}
