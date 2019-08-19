package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractSpace() {
    }

    public ADEPropertyOfAbstractSpace(T value) {
        super(value);
    }
}
