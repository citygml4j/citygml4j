package org.citygml4j.model.dynamizer;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfCompositeTimeseries<T> extends ADEProperty<T> {

    public ADEPropertyOfCompositeTimeseries() {
    }

    public ADEPropertyOfCompositeTimeseries(T value) {
        super(value);
    }
}
