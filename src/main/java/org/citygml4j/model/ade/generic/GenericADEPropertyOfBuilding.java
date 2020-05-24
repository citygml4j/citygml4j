package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfBuilding;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuilding extends ADEOfBuilding<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuilding(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuilding of(Element value) {
        return new GenericADEPropertyOfBuilding(value);
    }
}
