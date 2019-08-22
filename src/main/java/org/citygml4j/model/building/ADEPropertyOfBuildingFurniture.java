package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBuildingFurniture<T> extends ADEProperty<T> {

    public ADEPropertyOfBuildingFurniture() {
    }

    public ADEPropertyOfBuildingFurniture(T value) {
        super(value);
    }
}
