package org.citygml4j.model.waterbody;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfWaterClosureSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfWaterClosureSurface() {
    }

    public ADEPropertyOfWaterClosureSurface(T value) {
        super(value);
    }
}
