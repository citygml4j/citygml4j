package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractConstruction;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractConstruction extends ADEOfAbstractConstruction<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractConstruction(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractConstruction of(Element value) {
        return new GenericADEPropertyOfAbstractConstruction(value);
    }
}
