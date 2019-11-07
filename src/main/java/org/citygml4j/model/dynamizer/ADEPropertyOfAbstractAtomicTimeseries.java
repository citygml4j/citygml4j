package org.citygml4j.model.dynamizer;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractAtomicTimeseries<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractAtomicTimeseries() {
    }

    public ADEPropertyOfAbstractAtomicTimeseries(T value) {
        super(value);
    }
}
