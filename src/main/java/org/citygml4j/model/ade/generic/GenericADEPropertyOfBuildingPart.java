package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingPart;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingPart extends ADEOfBuildingPart<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingPart(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingPart of(Element value) {
        return new GenericADEPropertyOfBuildingPart(value);
    }
}
