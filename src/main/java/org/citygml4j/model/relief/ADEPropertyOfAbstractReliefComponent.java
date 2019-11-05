package org.citygml4j.model.relief;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractReliefComponent<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractReliefComponent() {
    }

    public ADEPropertyOfAbstractReliefComponent(T value) {
        super(value);
    }
}
