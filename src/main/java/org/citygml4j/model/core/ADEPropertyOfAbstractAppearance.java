package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractAppearance<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractAppearance() {
    }

    public ADEPropertyOfAbstractAppearance(T value) {
        super(value);
    }
}
