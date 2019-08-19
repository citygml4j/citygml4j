package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractUnoccupiedSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractUnoccupiedSpace() {
    }

    public ADEPropertyOfAbstractUnoccupiedSpace(T value) {
        super(value);
    }
}
