package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractBuildingSubdivision<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractBuildingSubdivision() {
    }

    public ADEPropertyOfAbstractBuildingSubdivision(T value) {
        super(value);
    }
}
