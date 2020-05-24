package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuildingConstructiveElement;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuildingConstructiveElement extends ADEOfBuildingConstructiveElement<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuildingConstructiveElement(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuildingConstructiveElement of(Element value) {
        return new GenericADEPropertyOfBuildingConstructiveElement(value);
    }
}
