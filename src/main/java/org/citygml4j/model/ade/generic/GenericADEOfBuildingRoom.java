package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingRoom;
import org.w3c.dom.Element;

public class GenericADEOfBuildingRoom extends ADEOfBuildingRoom implements ADEGenericContainer {
    private Element value;

    private GenericADEOfBuildingRoom(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingRoom of(Element value) {
        return new GenericADEOfBuildingRoom(value);
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
