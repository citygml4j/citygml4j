/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
