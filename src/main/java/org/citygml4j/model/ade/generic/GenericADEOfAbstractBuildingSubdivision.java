package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfAbstractBuildingSubdivision;
import org.w3c.dom.Element;

public class GenericADEOfAbstractBuildingSubdivision extends ADEOfAbstractBuildingSubdivision implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractBuildingSubdivision() {
    }

    public GenericADEOfAbstractBuildingSubdivision(Element value) {
        this.value = value;
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
