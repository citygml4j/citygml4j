package org.citygml4j.model.appearance;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAppearance<T> extends ADEProperty<T> {

    public ADEPropertyOfAppearance() {
    }

    public ADEPropertyOfAppearance(T value) {
        super(value);
    }
}
