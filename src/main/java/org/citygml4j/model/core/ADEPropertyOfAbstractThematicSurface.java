package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractThematicSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractThematicSurface() {
    }

    public ADEPropertyOfAbstractThematicSurface(T value) {
        super(value);
    }
}
