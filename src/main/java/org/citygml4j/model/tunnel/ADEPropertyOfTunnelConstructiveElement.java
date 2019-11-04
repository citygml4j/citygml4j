package org.citygml4j.model.tunnel;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTunnelConstructiveElement<T> extends ADEProperty<T> {

    public ADEPropertyOfTunnelConstructiveElement() {
    }

    public ADEPropertyOfTunnelConstructiveElement(T value) {
        super(value);
    }
}
