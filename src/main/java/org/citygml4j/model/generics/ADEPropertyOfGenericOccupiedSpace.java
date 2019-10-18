package org.citygml4j.model.generics;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfGenericOccupiedSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfGenericOccupiedSpace() {
    }

    public ADEPropertyOfGenericOccupiedSpace(T value) {
        super(value);
    }
}
