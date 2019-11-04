package org.citygml4j.model.bridge;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBridgeInstallation<T> extends ADEProperty<T> {

    public ADEPropertyOfBridgeInstallation() {
    }

    public ADEPropertyOfBridgeInstallation(T value) {
        super(value);
    }
}
