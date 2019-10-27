package org.citygml4j.model.waterbody;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfWaterGroundSurface<T> extends ADEProperty<T> {

    public ADEPropertyOfWaterGroundSurface() {
    }

    public ADEPropertyOfWaterGroundSurface(T value) {
        super(value);
    }
}
