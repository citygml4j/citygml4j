package org.citygml4j.model.tunnel;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTunnel<T> extends ADEProperty<T> {

    public ADEPropertyOfTunnel() {
    }

    public ADEPropertyOfTunnel(T value) {
        super(value);
    }
}
