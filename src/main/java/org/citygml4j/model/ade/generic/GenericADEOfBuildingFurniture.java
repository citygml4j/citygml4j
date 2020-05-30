package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingFurniture;
import org.w3c.dom.Element;

public class GenericADEOfBuildingFurniture extends ADEOfBuildingFurniture implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBuildingFurniture() {
    }

    public GenericADEOfBuildingFurniture(Element value) {
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
