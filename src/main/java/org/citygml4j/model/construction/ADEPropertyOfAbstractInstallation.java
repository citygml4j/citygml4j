package org.citygml4j.model.construction;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractInstallation<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractInstallation() {
    }

    public ADEPropertyOfAbstractInstallation(T value) {
        super(value);
    }
}
