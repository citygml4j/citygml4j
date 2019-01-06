package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.model.gml.feature.AbstractFeature;

public class ExtensionPropertyContext {
    private final Object value;
    private final CityJSON cityJSON;
    private final AbstractFeature parent;

    public ExtensionPropertyContext(Object value, CityJSON cityJSON, AbstractFeature parent) {
        this.value = value;
        this.cityJSON = cityJSON;
        this.parent = parent;
    }

    public Object getValue() {
        return value;
    }

    public CityJSON getCityJSON() {
        return cityJSON;
    }

    public AbstractFeature getParent() {
        return parent;
    }
}
