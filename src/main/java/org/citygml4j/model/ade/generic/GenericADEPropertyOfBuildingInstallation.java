package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEPropertyOfBuildingInstallation;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingInstallation extends ADEPropertyOfBuildingInstallation<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingInstallation(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingInstallation of(Element value) {
        return new GenericADEPropertyOfBuildingInstallation(value);
    }
}
