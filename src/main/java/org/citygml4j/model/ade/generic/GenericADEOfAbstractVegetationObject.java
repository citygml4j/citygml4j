package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEOfAbstractVegetationObject;
import org.w3c.dom.Element;

public class GenericADEOfAbstractVegetationObject extends ADEOfAbstractVegetationObject implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractVegetationObject(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractVegetationObject of(Element value) {
        return new GenericADEOfAbstractVegetationObject(value);
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
