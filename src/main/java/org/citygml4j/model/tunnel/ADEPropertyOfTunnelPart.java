package org.citygml4j.model.tunnel;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTunnelPart<T> extends ADEProperty<T> {

    public ADEPropertyOfTunnelPart() {
    }

    public ADEPropertyOfTunnelPart(T value) {
        super(value);
    }
}
