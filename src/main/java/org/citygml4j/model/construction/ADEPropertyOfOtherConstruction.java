package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfOtherConstruction<T> extends ADEProperty<T> {

    public ADEPropertyOfOtherConstruction() {
    }

    public ADEPropertyOfOtherConstruction(T value) {
        super(value);
    }
}
