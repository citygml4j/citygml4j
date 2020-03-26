package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractFeature<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractFeature() {
    }

    public ADEPropertyOfAbstractFeature(T value) {
        super(value);
    }
}
