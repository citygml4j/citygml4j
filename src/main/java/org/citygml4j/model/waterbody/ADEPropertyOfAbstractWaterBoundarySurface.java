package org.citygml4j.model.waterbody;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractWaterBoundarySurface<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractWaterBoundarySurface() {
    }

    public ADEPropertyOfAbstractWaterBoundarySurface(T value) {
        super(value);
    }
}
