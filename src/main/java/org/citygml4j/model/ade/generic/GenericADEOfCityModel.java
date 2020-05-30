package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfCityModel;
import org.w3c.dom.Element;

public class GenericADEOfCityModel extends ADEOfCityModel implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfCityModel() {
    }

    public GenericADEOfCityModel(Element value) {
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
