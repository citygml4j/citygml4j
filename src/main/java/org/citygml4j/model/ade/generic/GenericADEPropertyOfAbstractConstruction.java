package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfAbstractConstruction;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractConstruction extends ADEPropertyOfAbstractConstruction<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractConstruction(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractConstruction of(Element value) {
        return new GenericADEPropertyOfAbstractConstruction(value);
    }
}
