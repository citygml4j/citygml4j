/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
