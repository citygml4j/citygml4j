package org.citygml4j.model.dynamizer;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfStandardFileTimeseries<T> extends ADEProperty<T> {

    public ADEPropertyOfStandardFileTimeseries() {
    }

    public ADEPropertyOfStandardFileTimeseries(T value) {
        super(value);
    }
}
