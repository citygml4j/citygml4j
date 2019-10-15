package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractVersion<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractVersion() {
    }

    public ADEPropertyOfAbstractVersion(T value) {
        super(value);
    }
}
