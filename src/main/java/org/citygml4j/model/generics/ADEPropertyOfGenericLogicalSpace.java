package org.citygml4j.model.generics;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfGenericLogicalSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfGenericLogicalSpace() {
    }

    public ADEPropertyOfGenericLogicalSpace(T value) {
        super(value);
    }
}
