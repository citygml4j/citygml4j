package org.citygml4j.model.bridge;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBridgeConstructiveElement<T> extends ADEProperty<T> {

    public ADEPropertyOfBridgeConstructiveElement() {
    }

    public ADEPropertyOfBridgeConstructiveElement(T value) {
        super(value);
    }
}
