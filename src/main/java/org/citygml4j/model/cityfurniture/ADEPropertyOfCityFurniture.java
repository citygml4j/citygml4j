package org.citygml4j.model.cityfurniture;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfCityFurniture<T> extends ADEProperty<T> {

    public ADEPropertyOfCityFurniture() {
    }

    public ADEPropertyOfCityFurniture(T value) {
        super(value);
    }
}
