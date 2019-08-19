package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractFillingElement<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractFillingElement() {
    }

    public ADEPropertyOfAbstractFillingElement(T value) {
        super(value);
    }
}
