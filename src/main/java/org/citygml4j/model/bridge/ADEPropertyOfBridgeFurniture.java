package org.citygml4j.model.bridge;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBridgeFurniture<T> extends ADEProperty<T> {

    public ADEPropertyOfBridgeFurniture() {
    }

    public ADEPropertyOfBridgeFurniture(T value) {
        super(value);
    }
}
