package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingFurniture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingFurniture extends ADEOfBuildingFurniture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingFurniture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingFurniture of(Element value) {
        return new GenericADEPropertyOfBuildingFurniture(value);
    }
}
