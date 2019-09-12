package org.citygml4j.model.appearance;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfX3DMaterial<T> extends ADEProperty<T> {

    public ADEPropertyOfX3DMaterial() {
    }

    public ADEPropertyOfX3DMaterial(T value) {
        super(value);
    }
}
