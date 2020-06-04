package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfRailway;
import org.w3c.dom.Element;

public class GenericADEOfRailway extends ADEOfRailway implements ADEGenericContainer {
    private Element value;

    private GenericADEOfRailway(Element value) {
        this.value = value;
    }

    public static GenericADEOfRailway of(Element value) {
        return new GenericADEOfRailway(value);
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
