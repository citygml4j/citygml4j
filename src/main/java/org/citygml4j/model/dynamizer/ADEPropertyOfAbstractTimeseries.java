package org.citygml4j.model.dynamizer;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractTimeseries<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractTimeseries() {
    }

    public ADEPropertyOfAbstractTimeseries(T value) {
        super(value);
    }
}
