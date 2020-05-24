package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingRoom;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingRoom extends ADEOfBuildingRoom<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingRoom(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingRoom of(Element value) {
        return new GenericADEPropertyOfBuildingRoom(value);
    }
}
