package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfWindow<T> extends ADEProperty<T> {

    public ADEPropertyOfWindow() {
    }

    public ADEPropertyOfWindow(T value) {
        super(value);
    }
}
