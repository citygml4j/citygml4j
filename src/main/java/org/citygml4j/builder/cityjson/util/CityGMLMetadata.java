package org.citygml4j.builder.cityjson.util;

import java.util.HashMap;
import java.util.Map;

public class CityGMLMetadata {
    public static final String JSON_KEY = "CityGMLMetadata";
    private Map<String, GenericAttributeType> genericAttributeTypes;

    public boolean isSetGenericAttributeTypes() {
        return genericAttributeTypes != null;
    }

    public void addGenericAttributeType(String name, GenericAttributeType type) {
        if (genericAttributeTypes == null)
            genericAttributeTypes = new HashMap<>();

        genericAttributeTypes.put(name, type);
    }

    public Map<String, GenericAttributeType> getGenericAttributeTypes() {
        return genericAttributeTypes;
    }

    public GenericAttributeType getGenericAttributeType(String name) {
        return genericAttributeTypes != null ? genericAttributeTypes.get(name) : null;
    }

    public void setGenericAttributeTypes(Map<String, GenericAttributeType> genericAttributeTypes) {
        if (genericAttributeTypes != null)
            this.genericAttributeTypes = genericAttributeTypes;
    }

    public void removeGenericAttributeType(String name) {
        if (genericAttributeTypes != null)
            genericAttributeTypes.remove(name);
    }

    public void unsetGenericAttributeTypes() {
        genericAttributeTypes = null;
    }
}
