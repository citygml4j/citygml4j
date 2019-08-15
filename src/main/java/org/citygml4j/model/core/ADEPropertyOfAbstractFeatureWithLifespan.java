package org.citygml4j.model.core;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractFeatureWithLifespan<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractFeatureWithLifespan() {
    }

    public ADEPropertyOfAbstractFeatureWithLifespan(T value) {
        super(value);
    }
}
