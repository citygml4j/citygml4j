package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBuildingConstructiveElement<T> extends ADEProperty<T> {

    public ADEPropertyOfBuildingConstructiveElement() {
    }

    public ADEPropertyOfBuildingConstructiveElement(T value) {
        super(value);
    }
}
