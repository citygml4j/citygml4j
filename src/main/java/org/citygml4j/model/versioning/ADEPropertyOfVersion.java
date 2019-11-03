package org.citygml4j.model.versioning;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfVersion<T> extends ADEProperty<T> {

    public ADEPropertyOfVersion() {
    }

    public ADEPropertyOfVersion(T value) {
        super(value);
    }
}
