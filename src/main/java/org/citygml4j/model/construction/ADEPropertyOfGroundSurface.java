package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfGroundSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfGroundSurface() {
    }

    public ADEPropertyOfGroundSurface(T value) {
        super(value);
    }
}
