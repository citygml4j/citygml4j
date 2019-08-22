package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBuildingUnit<T> extends ADEProperty<T> {

    public ADEPropertyOfBuildingUnit() {
    }

    public ADEPropertyOfBuildingUnit(T value) {
        super(value);
    }
}
