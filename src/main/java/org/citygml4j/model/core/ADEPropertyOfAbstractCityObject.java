package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractCityObject<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractCityObject() {
    }

    public ADEPropertyOfAbstractCityObject(T value) {
        super(value);
    }
}
