package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.model.citygml.core.AbstractCityObject;

public class ExtensionAttributeContext {
    private final Object value;
    private final CityJSON cityJSON;
    private final AbstractCityObject parent;

    public ExtensionAttributeContext(Object value, CityJSON cityJSON, AbstractCityObject parent) {
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

    public AbstractCityObject getParent() {
        return parent;
    }
}
