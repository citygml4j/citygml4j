package org.citygml4j.model.bridge;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBridge<T> extends ADEProperty<T> {

    public ADEPropertyOfBridge() {
    }

    public ADEPropertyOfBridge(T value) {
        super(value);
    }
}
