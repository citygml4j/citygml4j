package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfWaterway<T> extends ADEProperty<T> {

    public ADEPropertyOfWaterway() {
    }

    public ADEPropertyOfWaterway(T value) {
        super(value);
    }
}
