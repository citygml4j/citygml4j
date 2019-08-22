package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBuilding<T> extends ADEProperty<T> {

    public ADEPropertyOfBuilding() {
    }

    public ADEPropertyOfBuilding(T value) {
        super(value);
    }
}
