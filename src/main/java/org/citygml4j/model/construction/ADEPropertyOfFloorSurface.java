package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfFloorSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfFloorSurface() {
    }

    public ADEPropertyOfFloorSurface(T value) {
        super(value);
    }
}
