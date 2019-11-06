package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTrafficArea<T> extends ADEProperty<T> {

    public ADEPropertyOfTrafficArea() {
    }

    public ADEPropertyOfTrafficArea(T value) {
        super(value);
    }
}
