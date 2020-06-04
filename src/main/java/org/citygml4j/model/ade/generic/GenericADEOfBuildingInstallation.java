package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingInstallation;
import org.w3c.dom.Element;

public class GenericADEOfBuildingInstallation extends ADEOfBuildingInstallation implements ADEGenericContainer {
    private Element value;

    private GenericADEOfBuildingInstallation(Element value) {
        this.value = value;
    }

    public static GenericADEOfBuildingInstallation of(Element value) {
        return new GenericADEOfBuildingInstallation(value);
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
