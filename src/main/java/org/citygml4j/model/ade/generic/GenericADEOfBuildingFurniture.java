package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingFurniture;
import org.w3c.dom.Element;

public class GenericADEOfBuildingFurniture extends ADEOfBuildingFurniture implements ADEGenericContainer {
    private Element value;

    private GenericADEOfBuildingFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingFurniture of(Element value) {
        return new GenericADEOfBuildingFurniture(value);
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
