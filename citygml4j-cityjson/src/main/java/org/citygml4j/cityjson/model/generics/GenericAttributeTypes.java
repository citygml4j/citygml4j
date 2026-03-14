/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.generics;

import org.citygml4j.core.model.core.ADEOfCityModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GenericAttributeTypes extends ADEOfCityModel {
    public static final String PROPERTY_NAME = "+GenericAttributeTypes";
    private Map<String, GenericAttributeType> types;

    public void addType(String name, GenericAttributeType type) {
        if (types == null) {
            types = new HashMap<>();
        }

        types.put(name, type);
    }

    public GenericAttributeType getType(String name) {
        return types != null ? types.get(name) : null;
    }

    public Map<String, GenericAttributeType> getTypes() {
        return types != null ? types : Collections.emptyMap();
    }
}
