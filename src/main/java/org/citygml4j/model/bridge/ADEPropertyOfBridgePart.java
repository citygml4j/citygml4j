package org.citygml4j.model.bridge;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBridgePart<T> extends ADEProperty<T> {

    public ADEPropertyOfBridgePart() {
    }

    public ADEPropertyOfBridgePart(T value) {
        super(value);
    }
}
