package org.citygml4j.model.waterbody;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfWaterBody<T> extends ADEProperty<T> {

    public ADEPropertyOfWaterBody() {
    }

    public ADEPropertyOfWaterBody(T value) {
        super(value);
    }
}
