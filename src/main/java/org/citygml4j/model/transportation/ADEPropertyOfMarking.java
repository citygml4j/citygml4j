package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfMarking<T> extends ADEProperty<T> {

    public ADEPropertyOfMarking() {
    }

    public ADEPropertyOfMarking(T value) {
        super(value);
    }
}
