package org.citygml4j.model.generics;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfGenericUnoccupiedSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfGenericUnoccupiedSpace() {
    }

    public ADEPropertyOfGenericUnoccupiedSpace(T value) {
        super(value);
    }
}
