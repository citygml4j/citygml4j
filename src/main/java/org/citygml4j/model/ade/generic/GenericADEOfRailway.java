package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfRailway;
import org.w3c.dom.Element;

public class GenericADEOfRailway extends ADEOfRailway implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfRailway() {
    }

    public GenericADEOfRailway(Element value) {
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
