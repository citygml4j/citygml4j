package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingPart;
import org.w3c.dom.Element;

public class GenericADEOfBuildingPart extends ADEOfBuildingPart implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfBuildingPart(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingPart of(Element value) {
        return new GenericADEOfBuildingPart(value);
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
