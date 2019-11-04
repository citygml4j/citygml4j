package org.citygml4j.model.bridge;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractBridge<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractBridge() {
    }

    public ADEPropertyOfAbstractBridge(T value) {
        super(value);
    }
}
