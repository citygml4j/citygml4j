package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfAbstractConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractConstructiveElement extends ADEPropertyOfAbstractConstructiveElement<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractConstructiveElement(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractConstructiveElement of(Element value) {
        return new GenericADEPropertyOfAbstractConstructiveElement(value);
    }
}
