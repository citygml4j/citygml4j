package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBuildingPart<T> extends ADEProperty<T> {

    public ADEPropertyOfBuildingPart() {
    }

    public ADEPropertyOfBuildingPart(T value) {
        super(value);
    }
}
