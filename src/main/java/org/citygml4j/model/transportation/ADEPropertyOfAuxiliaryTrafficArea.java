package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAuxiliaryTrafficArea<T> extends ADEProperty<T> {

    public ADEPropertyOfAuxiliaryTrafficArea() {
    }

    public ADEPropertyOfAuxiliaryTrafficArea(T value) {
        super(value);
    }
}
