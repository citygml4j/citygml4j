package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfClearanceSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfClearanceSpace() {
    }

    public ADEPropertyOfClearanceSpace(T value) {
        super(value);
    }
}
