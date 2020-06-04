package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuilding;
import org.w3c.dom.Element;

public class GenericADEOfBuilding extends ADEOfBuilding implements ADEGenericContainer {
    private Element value;

    private GenericADEOfBuilding(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuilding of(Element value) {
        return new GenericADEOfBuilding(value);
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
