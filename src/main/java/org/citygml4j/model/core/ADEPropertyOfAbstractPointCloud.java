package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractPointCloud<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractPointCloud() {
    }

    public ADEPropertyOfAbstractPointCloud(T value) {
        super(value);
    }
}
