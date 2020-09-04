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

package org.citygml4j.model.core;

public enum RelativeToWater {
    ENTIRELY_ABOVE_WATER_SURFACE("entirelyAboveWaterSurface"),
    SUBSTANTIALLY_ABOVE_WATER_SURFACE("substantiallyAboveWaterSurface"),
    SUBSTANTIALLY_ABOVE_AND_BELOW_WATER_SURFACE("substantiallyAboveAndBelowWaterSurface"),
    SUBSTANTIALLY_BELOW_WATER_SURFACE("substantiallyBelowWaterSurface"),
    ENTIRELY_BELOW_WATER_SURFACE("entirelyBelowWaterSurface"),
    TEMPORARILY_ABOVE_AND_BELOW_WATER_SURFACE("temporarilyAboveAndBelowWaterSurface");

    private final String value;

    RelativeToWater(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static RelativeToWater fromValue(String value) {
        for (RelativeToWater v : RelativeToWater.values()) {
            if (v.value.equals(value))
                return v;
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
