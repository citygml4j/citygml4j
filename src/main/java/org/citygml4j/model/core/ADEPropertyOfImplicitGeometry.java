package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfImplicitGeometry<T> extends ADEProperty<T> {

    public ADEPropertyOfImplicitGeometry() {
    }

    public ADEPropertyOfImplicitGeometry(T value) {
        super(value);
    }
}
