package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractBuilding<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractBuilding() {
    }

    public ADEPropertyOfAbstractBuilding(T value) {
        super(value);
    }
}
