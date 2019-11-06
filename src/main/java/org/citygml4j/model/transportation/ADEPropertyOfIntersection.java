package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfIntersection<T> extends ADEProperty<T> {

    public ADEPropertyOfIntersection() {
    }

    public ADEPropertyOfIntersection(T value) {
        super(value);
    }
}
