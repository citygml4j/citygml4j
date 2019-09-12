package org.citygml4j.model.appearance;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfGeoreferencedTexture<T> extends ADEProperty<T> {

    public ADEPropertyOfGeoreferencedTexture() {
    }

    public ADEPropertyOfGeoreferencedTexture(T value) {
        super(value);
    }
}
