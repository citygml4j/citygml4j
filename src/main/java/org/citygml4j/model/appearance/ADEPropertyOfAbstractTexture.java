package org.citygml4j.model.appearance;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractTexture<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractTexture() {
    }

    public ADEPropertyOfAbstractTexture(T value) {
        super(value);
    }
}
