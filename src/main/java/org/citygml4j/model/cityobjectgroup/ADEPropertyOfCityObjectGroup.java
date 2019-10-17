package org.citygml4j.model.cityobjectgroup;

import org.citygml4j.model.ade.ADEProperty;

public abstract class ADEPropertyOfCityObjectGroup<T> extends ADEProperty<T> {

    public ADEPropertyOfCityObjectGroup() {
    }

    public ADEPropertyOfCityObjectGroup(T value) {
        super(value);
    }
}
