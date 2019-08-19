package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractConstructionSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractConstructionSurface() {
    }

    public ADEPropertyOfAbstractConstructionSurface(T value) {
        super(value);
    }
}
