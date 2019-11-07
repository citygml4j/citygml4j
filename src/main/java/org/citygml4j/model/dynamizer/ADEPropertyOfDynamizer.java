package org.citygml4j.model.dynamizer;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfDynamizer<T> extends ADEProperty<T> {

    public ADEPropertyOfDynamizer() {
    }

    public ADEPropertyOfDynamizer(T value) {
        super(value);
    }
}
