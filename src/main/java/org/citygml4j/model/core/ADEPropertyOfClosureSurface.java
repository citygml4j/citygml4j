package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfClosureSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfClosureSurface() {
    }

    public ADEPropertyOfClosureSurface(T value) {
        super(value);
    }
}
