package org.citygml4j.model.relief;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfMassPointRelief<T> extends ADEProperty<T> {

    public ADEPropertyOfMassPointRelief() {
    }

    public ADEPropertyOfMassPointRelief(T value) {
        super(value);
    }
}
