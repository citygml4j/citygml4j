package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfStorey<T> extends ADEProperty<T> {

    public ADEPropertyOfStorey() {
    }

    public ADEPropertyOfStorey(T value) {
        super(value);
    }
}
