package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractFurniture<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractFurniture() {
    }

    public ADEPropertyOfAbstractFurniture(T value) {
        super(value);
    }
}
