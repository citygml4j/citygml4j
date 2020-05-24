package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingUnit;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingUnit extends ADEOfBuildingUnit<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingUnit(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingUnit of(Element value) {
        return new GenericADEPropertyOfBuildingUnit(value);
    }
}
