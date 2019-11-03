package org.citygml4j.model.vegetation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfPlantCover<T> extends ADEProperty<T> {

    public ADEPropertyOfPlantCover() {
    }

    public ADEPropertyOfPlantCover(T value) {
        super(value);
    }
}
