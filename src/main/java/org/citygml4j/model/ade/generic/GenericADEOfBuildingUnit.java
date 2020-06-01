package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingUnit;
import org.w3c.dom.Element;

public class GenericADEOfBuildingUnit extends ADEOfBuildingUnit implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfBuildingUnit(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingUnit of(Element value) {
        return new GenericADEOfBuildingUnit(value);
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
