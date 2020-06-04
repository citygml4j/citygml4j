package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEOfBuildingConstructiveElement extends ADEOfBuildingConstructiveElement implements ADEGenericContainer {
    private Element value;

    private GenericADEOfBuildingConstructiveElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingConstructiveElement of(Element value) {
        return new GenericADEOfBuildingConstructiveElement(value);
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
