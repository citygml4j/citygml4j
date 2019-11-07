package org.citygml4j.model.dynamizer;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfGenericTimeseries<T> extends ADEProperty<T> {

    public ADEPropertyOfGenericTimeseries() {
    }

    public ADEPropertyOfGenericTimeseries(T value) {
        super(value);
    }
}
