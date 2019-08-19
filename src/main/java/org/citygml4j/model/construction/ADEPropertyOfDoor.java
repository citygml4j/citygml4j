package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfDoor<T> extends ADEProperty<T> {

    public ADEPropertyOfDoor() {
    }

    public ADEPropertyOfDoor(T value) {
        super(value);
    }
}
