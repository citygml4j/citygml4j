/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
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

package org.citygml4j.builder.cityjson.util;

import com.google.gson.annotations.SerializedName;
import org.citygml4j.model.citygml.CityGMLClass;

public enum GenericAttributeType {
    @SerializedName("stringAttribute")
    STRING_ATTRIBUTE("stringAttribute"),
    @SerializedName("intAttribute")
    INT_ATTRIBUTE("intAttribute"),
    @SerializedName("doubleAttribute")
    DOUBLE_ATTRIBUTE("doubleAttribute"),
    @SerializedName("dateAttribute")
    DATE_ATTRIBUTE("dateAttribute"),
    @SerializedName("uriAttribute")
    URI_ATTRIBUTE("uriAttribute"),
    @SerializedName("measureAttribute")
    MEASURE_ATTRIBUTE("measureAttribute"),
    @SerializedName("genericAttributeSet")
    GENERIC_ATTRIBUTE_SET("genericAttributeSet");

    private final String value;

    GenericAttributeType(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static GenericAttributeType fromValue(String value) {
        for (GenericAttributeType v : GenericAttributeType.values()) {
            if (v.value.equals(value))
                return v;
        }

        return null;
    }

    public static GenericAttributeType fromType(CityGMLClass type) {
        if (type != null) {
            switch (type) {
                case STRING_ATTRIBUTE:
                    return STRING_ATTRIBUTE;
                case INT_ATTRIBUTE:
                    return INT_ATTRIBUTE;
                case DOUBLE_ATTRIBUTE:
                    return DOUBLE_ATTRIBUTE;
                case DATE_ATTRIBUTE:
                    return DATE_ATTRIBUTE;
                case URI_ATTRIBUTE:
                    return URI_ATTRIBUTE;
                case MEASURE_ATTRIBUTE:
                    return MEASURE_ATTRIBUTE;
                case GENERIC_ATTRIBUTE_SET:
                    return GENERIC_ATTRIBUTE_SET;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
