package org.citygml4j.model.landuse;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfLandUse<T> extends ADEProperty<T> {

    public ADEPropertyOfLandUse() {
    }

    public ADEPropertyOfLandUse(T value) {
        super(value);
    }
}
