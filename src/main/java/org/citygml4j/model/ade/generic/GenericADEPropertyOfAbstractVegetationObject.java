package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEOfAbstractVegetationObject;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractVegetationObject extends ADEOfAbstractVegetationObject<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractVegetationObject(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractVegetationObject of(Element value) {
        return new GenericADEPropertyOfAbstractVegetationObject(value);
    }
}
