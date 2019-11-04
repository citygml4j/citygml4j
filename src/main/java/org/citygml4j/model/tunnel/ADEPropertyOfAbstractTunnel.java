package org.citygml4j.model.tunnel;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfAbstractTunnel<T> extends ADEProperty<T> {

    public ADEPropertyOfAbstractTunnel() {
    }

    public ADEPropertyOfAbstractTunnel(T value) {
        super(value);
    }
}
