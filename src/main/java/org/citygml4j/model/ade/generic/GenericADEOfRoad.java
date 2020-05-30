package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfRoad;
import org.w3c.dom.Element;

public class GenericADEOfRoad extends ADEOfRoad implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfRoad() {
    }

    public GenericADEOfRoad(Element value) {
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
