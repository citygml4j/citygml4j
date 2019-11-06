package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfHole<T> extends ADEProperty<T> {

    public ADEPropertyOfHole() {
    }

    public ADEPropertyOfHole(T value) {
        super(value);
    }
}
