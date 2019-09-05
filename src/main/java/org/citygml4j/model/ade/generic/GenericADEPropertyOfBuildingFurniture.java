package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEPropertyOfBuildingFurniture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingFurniture extends ADEPropertyOfBuildingFurniture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingFurniture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingFurniture of(Element value) {
        return new GenericADEPropertyOfBuildingFurniture(value);
    }
}
