package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAuxiliaryTrafficSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfAuxiliaryTrafficSpace() {
    }

    public ADEPropertyOfAuxiliaryTrafficSpace(T value) {
        super(value);
    }
}
