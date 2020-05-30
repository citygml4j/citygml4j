package org.citygml4j.model.ade.generic;

import org.citygml4j.model.cityobjectgroup.ADEOfCityObjectGroup;
import org.w3c.dom.Element;

public class GenericADEOfCityObjectGroup extends ADEOfCityObjectGroup implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfCityObjectGroup() {
    }

    public GenericADEOfCityObjectGroup(Element value) {
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
