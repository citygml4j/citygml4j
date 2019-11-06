package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfSection<T> extends ADEProperty<T> {

    public ADEPropertyOfSection() {
    }

    public ADEPropertyOfSection(T value) {
        super(value);
    }
}
