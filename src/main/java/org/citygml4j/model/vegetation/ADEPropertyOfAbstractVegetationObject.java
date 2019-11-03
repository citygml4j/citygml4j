package org.citygml4j.model.vegetation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractVegetationObject<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractVegetationObject() {
    }

    public ADEPropertyOfAbstractVegetationObject(T value) {
        super(value);
    }
}
