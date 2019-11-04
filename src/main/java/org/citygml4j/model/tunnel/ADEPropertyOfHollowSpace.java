package org.citygml4j.model.tunnel;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfHollowSpace<T> extends ADEProperty<T> {

    public ADEPropertyOfHollowSpace() {
    }

    public ADEPropertyOfHollowSpace(T value) {
        super(value);
    }
}
