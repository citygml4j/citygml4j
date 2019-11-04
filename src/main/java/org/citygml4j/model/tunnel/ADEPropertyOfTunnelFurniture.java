package org.citygml4j.model.tunnel;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTunnelFurniture<T> extends ADEProperty<T> {

    public ADEPropertyOfTunnelFurniture() {
    }

    public ADEPropertyOfTunnelFurniture(T value) {
        super(value);
    }
}
