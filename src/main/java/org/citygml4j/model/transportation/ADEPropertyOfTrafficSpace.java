package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTrafficSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfTrafficSpace() {
    }

    public ADEPropertyOfTrafficSpace(T value) {
        super(value);
    }
}
