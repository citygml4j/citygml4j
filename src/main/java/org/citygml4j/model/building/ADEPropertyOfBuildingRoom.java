package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBuildingRoom<T> extends ADEProperty<T> {

    public ADEPropertyOfBuildingRoom() {
    }

    public ADEPropertyOfBuildingRoom(T value) {
        super(value);
    }
}
