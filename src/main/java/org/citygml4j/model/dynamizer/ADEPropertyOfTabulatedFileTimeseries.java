package org.citygml4j.model.dynamizer;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTabulatedFileTimeseries<T> extends ADEProperty<T> {

    public ADEPropertyOfTabulatedFileTimeseries() {
    }

    public ADEPropertyOfTabulatedFileTimeseries(T value) {
        super(value);
    }
}
