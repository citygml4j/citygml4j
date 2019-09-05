package org.citygml4j.model.generics;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfGenericThematicSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfGenericThematicSurface() {
    }

    public ADEPropertyOfGenericThematicSurface(T value) {
        super(value);
    }
}
