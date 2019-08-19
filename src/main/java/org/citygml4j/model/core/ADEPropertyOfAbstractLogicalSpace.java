package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractLogicalSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractLogicalSpace() {
    }

    public ADEPropertyOfAbstractLogicalSpace(T value) {
        super(value);
    }
}
