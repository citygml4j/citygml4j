package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfWindowSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfWindowSurface() {
    }

    public ADEPropertyOfWindowSurface(T value) {
        super(value);
    }
}
