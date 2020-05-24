package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractFurniture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractFurniture extends ADEOfAbstractFurniture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractFurniture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractFurniture of(Element value) {
        return new GenericADEPropertyOfAbstractFurniture(value);
    }
}
