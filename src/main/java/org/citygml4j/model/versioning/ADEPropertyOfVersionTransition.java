package org.citygml4j.model.versioning;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfVersionTransition<T> extends ADEProperty<T> {

    public ADEPropertyOfVersionTransition() {
    }

    public ADEPropertyOfVersionTransition(T value) {
        super(value);
    }
}
