package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAbstractUnoccupiedSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractUnoccupiedSpace extends ADEPropertyOfAbstractUnoccupiedSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractUnoccupiedSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractUnoccupiedSpace of(Element value) {
        return new GenericADEPropertyOfAbstractUnoccupiedSpace(value);
    }
}
