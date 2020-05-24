package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEOfSolitaryVegetationObject;
import org.w3c.dom.Element;

public class GenericADEPropertyOfSolitaryVegetationObject extends ADEOfSolitaryVegetationObject<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfSolitaryVegetationObject(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfSolitaryVegetationObject of(Element value) {
        return new GenericADEPropertyOfSolitaryVegetationObject(value);
    }
}
