package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfAbstractBuilding;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBuilding extends ADEOfAbstractBuilding implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractBuilding(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractBuilding of(Element value) {
        return new GenericADEOfAbstractBuilding(value);
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
