package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEPropertyOfBuildingRoom;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingRoom extends ADEPropertyOfBuildingRoom<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingRoom(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingRoom of(Element value) {
        return new GenericADEPropertyOfBuildingRoom(value);
    }
}
