package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractPhysicalSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractPhysicalSpace() {
    }

    public ADEPropertyOfAbstractPhysicalSpace(T value) {
        super(value);
    }
}
