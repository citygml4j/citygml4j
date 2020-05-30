package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEOfSolitaryVegetationObject;
import org.w3c.dom.Element;

public class GenericADEOfSolitaryVegetationObject extends ADEOfSolitaryVegetationObject implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfSolitaryVegetationObject() {
    }

    public GenericADEOfSolitaryVegetationObject(Element value) {
        this.value = value;
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
