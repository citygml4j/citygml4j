package org.citygml4j.model.building;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfBuildingInstallation<T> extends ADEProperty<T> {

    public ADEPropertyOfBuildingInstallation() {
    }

    public ADEPropertyOfBuildingInstallation(T value) {
        super(value);
    }
}
