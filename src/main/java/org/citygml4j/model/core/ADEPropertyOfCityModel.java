package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfCityModel<T> extends ADEProperty<T> {

    public ADEPropertyOfCityModel() {
    }

    public ADEPropertyOfCityModel(T value) {
        super(value);
    }
}
