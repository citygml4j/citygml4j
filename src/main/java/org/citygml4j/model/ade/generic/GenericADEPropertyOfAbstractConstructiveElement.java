package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractConstructiveElement extends ADEOfAbstractConstructiveElement<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractConstructiveElement(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractConstructiveElement of(Element value) {
        return new GenericADEPropertyOfAbstractConstructiveElement(value);
    }
}
