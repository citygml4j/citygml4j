package org.citygml4j.model.waterbody;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfWaterSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfWaterSurface() {
    }

    public ADEPropertyOfWaterSurface(T value) {
        super(value);
    }
}
