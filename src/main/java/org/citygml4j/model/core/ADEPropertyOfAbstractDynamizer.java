package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractDynamizer<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractDynamizer() {
    }

    public ADEPropertyOfAbstractDynamizer(T value) {
        super(value);
    }
}
