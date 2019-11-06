package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfRailway<T> extends ADEProperty<T> {

    public ADEPropertyOfRailway() {
    }

    public ADEPropertyOfRailway(T value) {
        super(value);
    }
}
