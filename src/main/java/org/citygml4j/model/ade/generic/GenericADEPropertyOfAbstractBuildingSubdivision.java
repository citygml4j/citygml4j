package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEPropertyOfAbstractBuildingSubdivision;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractBuildingSubdivision extends ADEPropertyOfAbstractBuildingSubdivision<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractBuildingSubdivision(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractBuildingSubdivision of(Element value) {
        return new GenericADEPropertyOfAbstractBuildingSubdivision(value);
    }
}
