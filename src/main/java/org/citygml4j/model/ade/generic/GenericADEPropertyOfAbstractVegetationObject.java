package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEPropertyOfAbstractVegetationObject;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractVegetationObject extends ADEPropertyOfAbstractVegetationObject<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractVegetationObject(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractVegetationObject of(Element value) {
        return new GenericADEPropertyOfAbstractVegetationObject(value);
    }
}
