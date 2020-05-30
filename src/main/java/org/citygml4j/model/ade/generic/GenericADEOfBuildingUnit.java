package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingUnit;
import org.w3c.dom.Element;

public class GenericADEOfBuildingUnit extends ADEOfBuildingUnit implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBuildingUnit() {
    }

    public GenericADEOfBuildingUnit(Element value) {
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
