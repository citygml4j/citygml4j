package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfAbstractFillingElement;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractFillingElement extends ADEPropertyOfAbstractFillingElement<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractFillingElement(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractFillingElement of(Element value) {
        return new GenericADEPropertyOfAbstractFillingElement(value);
    }
}
