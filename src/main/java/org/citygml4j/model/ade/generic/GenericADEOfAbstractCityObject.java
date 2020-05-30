package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractCityObject;
import org.w3c.dom.Element;

public class GenericADEOfAbstractCityObject extends ADEOfAbstractCityObject implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractCityObject() {
    }

    public GenericADEOfAbstractCityObject(Element value) {
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
