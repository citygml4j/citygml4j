package org.citygml4j.model.pointcloud;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfPointCloud<T> extends ADEProperty<T> {

    public ADEPropertyOfPointCloud() {
    }

    public ADEPropertyOfPointCloud(T value) {
        super(value);
    }
}
