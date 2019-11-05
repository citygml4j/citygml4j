package org.citygml4j.model.relief;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfReliefFeature<T> extends ADEProperty<T> {

    public ADEPropertyOfReliefFeature() {
    }

    public ADEPropertyOfReliefFeature(T value) {
        super(value);
    }
}
