/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.CoreModule;

public enum RelativeToTerrain implements CoreModuleComponent, Copyable {
    ENTIRELY_ABOVE_TERRAIN("entirelyAboveTerrain"),
    SUBSTANTIALLY_ABOVE_TERRAIN("substantiallyAboveTerrain"),
    SUBSTANTIALLY_ABOVE_AND_BELOW_TERRAIN("substantiallyAboveAndBelowTerrain"),
    SUBSTANTIALLY_BELOW_TERRAIN("substantiallyBelowTerrain"),
    ENTIRELY_BELOW_TERRAIN("entirelyBelowTerrain");

	private final String value;
	private CoreModule module;

	RelativeToTerrain(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static RelativeToTerrain fromValue(String v) {
		v = v.trim().toLowerCase();

		for (RelativeToTerrain c: RelativeToTerrain.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}

		return ENTIRELY_ABOVE_TERRAIN;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELATIVE_TO_TERRAIN;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public String toString() {
		return value;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? ENTIRELY_ABOVE_TERRAIN : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}
	
}
