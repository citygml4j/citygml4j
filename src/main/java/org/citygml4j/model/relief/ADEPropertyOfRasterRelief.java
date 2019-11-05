package org.citygml4j.model.relief;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfRasterRelief<T> extends ADEProperty<T> {

    public ADEPropertyOfRasterRelief() {
    }

    public ADEPropertyOfRasterRelief(T value) {
        super(value);
    }
}
