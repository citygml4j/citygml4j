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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.AppearanceModule;

public enum WrapMode implements AppearanceModuleComponent, Copyable {
	NONE("none"),
	WRAP("wrap"),
	MIRROR("mirror"),
	CLAMP("clamp"),
	BORDER("border");

	private final String value;
	private AppearanceModule module;

	WrapMode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static WrapMode fromValue(String v) {
		v = v.trim().toLowerCase();

		for (WrapMode c: WrapMode.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}

		return NONE;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WRAP_MODE;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public String toString() {
		return value;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? NONE : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}
	
}
