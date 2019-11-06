package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfHoleSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfHoleSurface() {
    }

    public ADEPropertyOfHoleSurface(T value) {
        super(value);
    }
}
