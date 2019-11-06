package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfSquare<T> extends ADEProperty<T> {

    public ADEPropertyOfSquare() {
    }

    public ADEPropertyOfSquare(T value) {
        super(value);
    }
}
