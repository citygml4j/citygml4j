package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfCityModel;
import org.w3c.dom.Element;

public class GenericADEOfCityModel extends ADEOfCityModel implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfCityModel(Element value) {
        this.value = value;
    }

    public static GenericADEOfCityModel of(Element value) {
        return new GenericADEOfCityModel(value);
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
