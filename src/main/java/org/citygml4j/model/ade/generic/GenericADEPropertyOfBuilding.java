package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEPropertyOfBuilding;
import org.w3c.dom.Element;

public class GenericADEPropertyOfBuilding extends ADEPropertyOfBuilding<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfBuilding(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfBuilding of(Element value) {
        return new GenericADEPropertyOfBuilding(value);
    }
}
