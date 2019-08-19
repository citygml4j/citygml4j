package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractConstructiveElement<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractConstructiveElement() {
    }

    public ADEPropertyOfAbstractConstructiveElement(T value) {
        super(value);
    }
}
