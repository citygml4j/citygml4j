package org.citygml4j.model.deprecated.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTransportationComplex<T> extends ADEProperty<T> {

    public ADEPropertyOfTransportationComplex() {
    }

    public ADEPropertyOfTransportationComplex(T value) {
        super(value);
    }
}
