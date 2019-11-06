package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractTransportationSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractTransportationSpace() {
    }

    public ADEPropertyOfAbstractTransportationSpace(T value) {
        super(value);
    }
}
