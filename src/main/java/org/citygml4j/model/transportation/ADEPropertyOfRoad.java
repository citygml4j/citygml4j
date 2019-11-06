package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfRoad<T> extends ADEProperty<T> {

    public ADEPropertyOfRoad() {
    }

    public ADEPropertyOfRoad(T value) {
        super(value);
    }
}
