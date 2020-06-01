package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractCityObject;
import org.w3c.dom.Element;

public class GenericADEOfAbstractCityObject extends ADEOfAbstractCityObject implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractCityObject(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractCityObject of(Element value) {
        return new GenericADEOfAbstractCityObject(value);
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
