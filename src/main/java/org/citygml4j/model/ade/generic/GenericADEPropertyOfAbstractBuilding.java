package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfAbstractBuilding;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractBuilding extends ADEOfAbstractBuilding<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractBuilding(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractBuilding of(Element value) {
        return new GenericADEPropertyOfAbstractBuilding(value);
    }
}
