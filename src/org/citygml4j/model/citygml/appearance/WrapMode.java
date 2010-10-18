/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
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

	public ModelType getModelType() {
		return ModelType.CITYGML;
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
