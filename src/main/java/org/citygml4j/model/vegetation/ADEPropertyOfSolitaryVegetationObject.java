package org.citygml4j.model.vegetation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfSolitaryVegetationObject<T> extends ADEProperty<T> {

    public ADEPropertyOfSolitaryVegetationObject() {
    }

    public ADEPropertyOfSolitaryVegetationObject(T value) {
        super(value);
    }
}
