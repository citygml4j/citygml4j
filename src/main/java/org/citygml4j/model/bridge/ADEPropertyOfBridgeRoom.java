package org.citygml4j.model.bridge;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBridgeRoom<T> extends ADEProperty<T> {

    public ADEPropertyOfBridgeRoom() {
    }

    public ADEPropertyOfBridgeRoom(T value) {
        super(value);
    }
}
