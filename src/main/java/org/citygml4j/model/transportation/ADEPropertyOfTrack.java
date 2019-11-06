package org.citygml4j.model.transportation;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfTrack<T> extends ADEProperty<T> {

    public ADEPropertyOfTrack() {
    }

    public ADEPropertyOfTrack(T value) {
        super(value);
    }
}
