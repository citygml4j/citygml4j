package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractSpaceBoundary<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractSpaceBoundary() {
    }

    public ADEPropertyOfAbstractSpaceBoundary(T value) {
        super(value);
    }
}
