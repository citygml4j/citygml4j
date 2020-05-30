package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingRoom;
import org.w3c.dom.Element;

public class GenericADEOfBuildingRoom extends ADEOfBuildingRoom implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBuildingRoom() {
    }

    public GenericADEOfBuildingRoom(Element value) {
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
