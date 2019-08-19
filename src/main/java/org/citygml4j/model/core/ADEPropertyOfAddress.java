package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAddress<T> extends ADEProperty<T> {

    public ADEPropertyOfAddress() {
    }

    public ADEPropertyOfAddress(T value) {
        super(value);
    }
}
