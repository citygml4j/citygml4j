package org.citygml4j.model.tunnel;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTunnelInstallation<T> extends ADEProperty<T> {

    public ADEPropertyOfTunnelInstallation() {
    }

    public ADEPropertyOfTunnelInstallation(T value) {
        super(value);
    }
}
