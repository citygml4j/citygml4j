package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractOccupiedSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractOccupiedSpace() {
    }

    public ADEPropertyOfAbstractOccupiedSpace(T value) {
        super(value);
    }
}
