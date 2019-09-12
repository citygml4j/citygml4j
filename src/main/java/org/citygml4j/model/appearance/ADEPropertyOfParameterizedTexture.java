package org.citygml4j.model.appearance;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfParameterizedTexture<T> extends ADEProperty<T> {

    public ADEPropertyOfParameterizedTexture() {
    }

    public ADEPropertyOfParameterizedTexture(T value) {
        super(value);
    }
}
