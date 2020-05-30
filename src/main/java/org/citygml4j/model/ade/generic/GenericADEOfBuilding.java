package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuilding;
import org.w3c.dom.Element;

public class GenericADEOfBuilding extends ADEOfBuilding implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBuilding() {
    }

    public GenericADEOfBuilding(Element value) {
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
