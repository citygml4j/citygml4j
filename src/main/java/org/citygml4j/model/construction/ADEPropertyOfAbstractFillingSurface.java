package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractFillingSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractFillingSurface() {
    }

    public ADEPropertyOfAbstractFillingSurface(T value) {
        super(value);
    }
}
