package org.citygml4j.model.relief;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTINRelief<T> extends ADEProperty<T> {

    public ADEPropertyOfTINRelief() {
    }

    public ADEPropertyOfTINRelief(T value) {
        super(value);
    }
}
