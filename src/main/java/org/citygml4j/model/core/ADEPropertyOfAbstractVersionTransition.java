package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractVersionTransition<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractVersionTransition() {
    }

    public ADEPropertyOfAbstractVersionTransition(T value) {
        super(value);
    }
}
