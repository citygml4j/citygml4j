package org.citygml4j.model.appearance;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractSurfaceData<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractSurfaceData() {
    }

    public ADEPropertyOfAbstractSurfaceData(T value) {
        super(value);
    }
}
