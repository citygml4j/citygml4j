package org.citygml4j.model.ade.generic;

import org.citygml4j.model.cityobjectgroup.ADEOfCityObjectGroup;
import org.w3c.dom.Element;

public class GenericADEOfCityObjectGroup extends ADEOfCityObjectGroup implements ADEGenericContainer {
    private Element value;

    private GenericADEOfCityObjectGroup(Element value) {
        this.value = value;
    }

    public static GenericADEOfCityObjectGroup of(Element value) {
        return new GenericADEOfCityObjectGroup(value);
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
