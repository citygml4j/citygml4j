package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingInstallation;
import org.w3c.dom.Element;

public class GenericADEOfBuildingInstallation extends ADEOfBuildingInstallation implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBuildingInstallation() {
    }

    public GenericADEOfBuildingInstallation(Element value) {
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
