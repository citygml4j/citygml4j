package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfAbstractBuilding;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBuilding extends ADEOfAbstractBuilding implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractBuilding() {
    }

    public GenericADEOfAbstractBuilding(Element value) {
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
